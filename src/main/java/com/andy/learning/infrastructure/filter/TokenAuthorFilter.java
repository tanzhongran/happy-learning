package com.andy.learning.infrastructure.filter;


import com.alibaba.fastjson.JSON;
import com.andy.learning.infrastructure.token.Token;
import com.andy.learning.infrastructure.token.TokenManager;
import com.andy.learning.infrastructure.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


/***************
 * token验证拦截
 * @author bamboo zjcjava@163.com
 * @time 2017-08-01
 */
@Component
@WebFilter(urlPatterns = { "/*" }, filterName = "tokenAuthorFilter")
public class TokenAuthorFilter implements Filter {

    private static Logger logger = LoggerFactory
            .getLogger(TokenAuthorFilter.class);

    @Autowired
    TokenManager redisTokenManager;

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("/user/login", "/user/register")));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;

        //配置参数
        rep.setHeader("Access-Control-Allow-Methods","POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        //获取基本信息
        String token = req.getHeader("X-Token");//header方式
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");
        //如果无需过滤则直接通过
        if(ALLOWED_PATHS.contains(path)){
            chain.doFilter(request,response);
        }else{
            //校验token
            Result failedResult = null;
            if (null == token || token.isEmpty()) {
                failedResult = new Result("","用户授权认证没有通过!客户端请求参数中无token信息");
            } else {
                Token tokenBean = redisTokenManager.getUserInfoByToken(token);
                if (tokenBean!=null) {
                    //把tokenBean放入ThreadLocal
                    redisTokenManager.setLocalToken(tokenBean);
                } else {
                    failedResult = new Result("","用户授权认证没有通过!客户端请求参数token信息无效");
                }
            }
            //token验证失败则直接抛出结果
            if (failedResult!=null) {
                PrintWriter writer = null;
                OutputStreamWriter osw = null;
                try {
                    osw = new OutputStreamWriter(response.getOutputStream(),
                            "UTF-8");
                    writer = new PrintWriter(osw, true);
                    String jsonStr = JSON.toJSONString(failedResult);
                    writer.write(jsonStr);
                    writer.flush();
                    writer.close();
                    osw.close();
                } catch (UnsupportedEncodingException e) {
                    logger.error("过滤器返回信息失败:" + e.getMessage(), e);
                } catch (IOException e) {
                    logger.error("过滤器返回信息失败:" + e.getMessage(), e);
                } finally {
                    if (null != writer) {
                        writer.close();
                    }
                    if (null != osw) {
                        osw.close();
                    }
                }
                return;
            }else{
                //logger.info("token filter过滤ok!");
                chain.doFilter(request, response);
            }
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}

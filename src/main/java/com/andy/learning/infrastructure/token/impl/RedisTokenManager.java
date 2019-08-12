package com.andy.learning.infrastructure.token.impl;

import com.andy.learning.domain.entity.TRole;
import com.andy.learning.domain.entity.TUser;
import com.andy.learning.infrastructure.Constants;
import com.andy.learning.infrastructure.redis.RedisUtil;
import com.andy.learning.infrastructure.token.Token;
import com.andy.learning.infrastructure.token.TokenManager;
import com.andy.learning.infrastructure.util.CollectionBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class RedisTokenManager implements TokenManager {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * token过期时间（秒）
     */
    private static final long tokenExpireTime=1800;

    /**
     * 创建token
     *
     * @param user
     * @return
     */
    @Override
    public String getToken(TUser user) {

        //查看是否拥有token，如果已经有了，那么把老的作废（单点登录）
        String ssoId = String.format(Constants.SSO_FORMAT,String.valueOf(user.getId()));
        Object oriToken = redisUtil.get(ssoId);
        if(oriToken!=null){
            redisUtil.del(String.valueOf(oriToken));
        }

        //创建需要放入token的对象
        Token tokenBean = new Token();
        //拷贝一般字段
        BeanUtils.copyProperties(user,tokenBean);
        //手动放入role集合
        List<String> roles = CollectionBeanUtils.copyStringList(user.getRoles(),"role");
        tokenBean.setRoles(roles);

        //将token对象放入redis
        String token = UUID.randomUUID().toString().replace("-", "");//使用uuid作为源token
        token=String.format(Constants.TOKEN_FORMAT,token);
        redisUtil.set(token,tokenBean,tokenExpireTime);

        //放入客户id与token关联
        redisUtil.set(ssoId,token,tokenExpireTime);

        return token;
    }

    /**
     * 刷新用户
     *
     * @param token
     */
    @Override
    public void refreshUserToken(String token) {
        if(redisUtil.hasKey(token)){
            redisUtil.expire(token, tokenExpireTime);
        }
    }

    /**
     * 用户退出登陆
     *
     * @param token
     */
    @Override
    public void loginOff(String token) {
        redisUtil.del(token);
    }

    /**
     * 获取用户信息
     *
     * @param token
     * @return
     */
    @Override
    public Token getUserInfoByToken(String token) {
        if(redisUtil.hasKey(token)){
            return (Token)redisUtil.get(token);
        }
        return null;
    }
}

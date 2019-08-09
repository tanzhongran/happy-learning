package com.andy.learning.infrastructure.token.impl;

import com.andy.learning.domain.entity.TUser;
import com.andy.learning.infrastructure.Constants;
import com.andy.learning.infrastructure.redis.RedisUtil;
import com.andy.learning.infrastructure.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
     * @param member
     * @return
     */
    @Override
    public String getToken(TUser member) {
        //查看是否拥有token，如果已经有了，那么把老的作废（单点登录）
        String ssoId = String.format(Constants.SSO_FORMAT,String.valueOf(member.getId()));
        Object oriToken = redisUtil.get(ssoId);
        if(oriToken!=null){
            redisUtil.del(ssoId);
        }

        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        String token_format=String.format(Constants.TOKEN_FORMAT,token);
        redisUtil.set(token_format,member,tokenExpireTime);

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
    public TUser getUserInfoByToken(String token) {
        if(redisUtil.hasKey(token)){
            return (TUser)redisUtil.get(token);
        }
        return null;
    }
}

package com.andy.learning.domain.business.user.impl;

import com.andy.learning.domain.business.user.UserDomain;
import com.andy.learning.domain.entity.TUser;
import com.andy.learning.domain.repository.UserRepository;
import com.andy.learning.infrastructure.BizException;
import com.andy.learning.infrastructure.token.Token;
import com.andy.learning.infrastructure.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDomainImpl implements UserDomain {

    @Autowired
    UserRepository memberRepo;

    @Autowired
    TokenManager redisTokenManager;

    @Override
    public String login(String username,String password) throws Exception {
        //https://www.cnblogs.com/hongdada/p/9187981.html

        //查询账户名对应的登录信息
        TUser user = memberRepo.findTUserByUsername(username);
        if(user==null){
            throw new BizException("","账户不存在");
        }
        //校验密码
        if(!password.equals(user.getPassword())){
            throw new BizException("","密码错误");
        }

        //生成token
        String token = redisTokenManager.getToken(user);

        return token;
    }

    @Override
    public Token getTokenInfo(String token){
        Token tokenBean = redisTokenManager.getUserInfoByToken(token);
        return tokenBean;
    }

    @Override
    public TUser getUserInfoById(long id) throws Exception {
        return memberRepo.findTUserById(id);
    }


}

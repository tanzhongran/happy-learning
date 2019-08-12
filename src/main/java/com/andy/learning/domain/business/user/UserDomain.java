package com.andy.learning.domain.business.user;

import com.andy.learning.domain.entity.TUser;
import com.andy.learning.infrastructure.token.Token;

public interface UserDomain {

    public String login(String username,String password) throws Exception;

    public Token getTokenInfo(String token) throws Exception;

    public TUser getUserInfoById(long id) throws Exception;
}

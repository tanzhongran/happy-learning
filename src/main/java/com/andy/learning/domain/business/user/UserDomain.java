package com.andy.learning.domain.business.user;

import com.andy.learning.domain.entity.TUser;

public interface UserDomain {

    public String login(String username,String password) throws Exception;

    public TUser getTokenInfo(String token) throws Exception;
}

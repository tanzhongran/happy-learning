package com.andy.learning.infrastructure.token;

import com.andy.learning.domain.entity.TUser;

public interface TokenManager {
    /**
     * 创建token
     * @param member
     * @return
     */
    String getToken(TUser member);

    /**
     * 刷新用户
     * @param token
     */
    void refreshUserToken(String token);

    /**
     * 用户退出登陆
     * @param token
     */
    void loginOff(String token);

    /**
     * 获取用户信息
     * @param token
     * @return
     */
    Token getUserInfoByToken(String token);
}

package com.andy.learning.controller;


import com.andy.learning.domain.business.user.UserDomain;
import com.andy.learning.domain.entity.TUser;
import com.andy.learning.infrastructure.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDomain userDomain;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,String> login(@RequestBody TUser user) throws Exception{
        String token = userDomain.login(user.getUsername(),user.getPassword());
        System.out.println("token="+token);
        Map map = new HashMap();
        map.put("token",token);
        return map;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public Token getUserInfo(String token) throws Exception{
        Token tokenBean = userDomain.getTokenInfo(token);
        return tokenBean;
    }

    @RequestMapping(value = "/id",method = RequestMethod.GET)
    public TUser getUserInfoById(long id) throws Exception{
        return userDomain.getUserInfoById(id);
    }

}

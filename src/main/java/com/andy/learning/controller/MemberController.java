package com.andy.learning.controller;


import com.andy.learning.domain.business.user.UserDomain;
import com.andy.learning.domain.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class MemberController {

    @Autowired
    UserDomain memberDomain;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String,String> login(@RequestBody TUser user) throws Exception{
        String token = memberDomain.login(user.getUsername(),user.getPassword());
        System.out.println("token="+token);
        Map map = new HashMap();
        map.put("token",token);
        return map;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public TUser getUserInfo(String token) throws Exception{
        TUser user = memberDomain.getTokenInfo(token);
        return user;
    }

}

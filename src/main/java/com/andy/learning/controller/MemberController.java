package com.andy.learning.controller;


import com.andy.learning.domain.entity.TMember;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {

    @RequestMapping("/login")
    public TMember login(String loginName,String passWord,HttpServletRequest request) throws Exception{
        TMember member;
        HttpSession session = request.getSession();
        if(session.getAttribute("member")==null){
            member = new TMember();
            member.setId(1);
            member.setName("谈仲然");
            session.setAttribute("member",member);
            System.out.println("add new session");
        }else{
            member = (TMember)session.getAttribute("member");
            System.out.println(member);
        }

        return member;


    }

}

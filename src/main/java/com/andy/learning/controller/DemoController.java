package com.andy.learning.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class DemoController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result hello() {
       return Result.success("");
    }

}

package com.andy.learning.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo/")
public class DemoController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public List<String> hello() {
        List<String> result = new ArrayList<>();
        result.add("aaa");
        result.add("bbb");
        result.add("ccc");
        return result;
    }

}

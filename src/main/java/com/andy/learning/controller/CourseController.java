package com.andy.learning.controller;

import com.andy.learning.application.CourseService;
import com.andy.learning.infrastructure.Util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Result getCourseList(){
        return Result.success(courseService.getCourseList());
    }
}

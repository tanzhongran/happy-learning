package com.andy.learning.controller;

import com.andy.learning.application.CourseService;
import com.andy.learning.domain.entity.TCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<TCourse> getCourseList() throws Exception {
        String supCode = "YBSH0001";
        return courseService.getCourseList(supCode);
    }
}

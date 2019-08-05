package com.andy.learning.application.impl;

import com.andy.learning.application.CourseService;
import com.andy.learning.domain.business.course.CourseDomain;
import com.andy.learning.domain.entity.TCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDomain courseDomain;

    @Override
    public List<TCourse> getCourseList(String supCode) throws Exception{
        return courseDomain.getCourseList(supCode);
    }
}

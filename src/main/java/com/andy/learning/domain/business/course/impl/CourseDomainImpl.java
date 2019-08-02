package com.andy.learning.domain.business.course.impl;

import com.andy.learning.domain.business.course.CourseDomain;
import com.andy.learning.domain.entity.TCourse;
import com.andy.learning.domain.repository.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDomainImpl implements CourseDomain {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<TCourse> getCourseList() {
        return courseDao.findAll();
    }

}

package com.andy.learning.domain.business.course.impl;

import com.andy.learning.domain.business.course.CourseDomain;
import com.andy.learning.domain.entity.TCourse;
import com.andy.learning.domain.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseDomainImpl implements CourseDomain {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public List<TCourse> getCourseList(String supCode) {
        return courseRepo.findTCoursesBySupCodeAndStatus(supCode,"1");
    }

}

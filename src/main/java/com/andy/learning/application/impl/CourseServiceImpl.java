package com.andy.learning.application.impl;

import com.andy.learning.application.CourseService;
import com.andy.learning.domain.business.course.CourseDomain;
import com.andy.learning.domain.entity.TCourse;
import com.andy.learning.infrastructure.BizException;
import com.andy.learning.infrastructure.token.Token;
import com.andy.learning.infrastructure.token.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDomain courseDomain;

    @Autowired
    TokenManager redisTokenManager;

    @Override
    public List<TCourse> getCourseList() throws Exception{
        return courseDomain.getCourseList();
    }

    @Override
    public void saveCourse(TCourse course) throws Exception {
        courseDomain.saveCourse(course);
    }
}

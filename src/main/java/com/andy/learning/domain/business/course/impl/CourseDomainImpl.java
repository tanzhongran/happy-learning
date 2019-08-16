package com.andy.learning.domain.business.course.impl;

import com.andy.learning.domain.business.course.CourseDomain;
import com.andy.learning.domain.entity.TCourse;
import com.andy.learning.domain.repository.CourseRepository;
import com.andy.learning.infrastructure.BizException;
import com.andy.learning.infrastructure.token.TokenManager;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CourseDomainImpl implements CourseDomain {

    @Autowired
    TokenManager tokenManager;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public void saveCourse(TCourse course) throws Exception{
        //放入token内容
        if(StringUtils.isBlank(course.getSupCode())){
            course.setSupCode(tokenManager.getLocalToken().getSupCode());
        }

        //保存课程
        courseRepo.saveAndFlush(course);
    }

    @Override
    public List<TCourse> getCourseList() {
        String supCode = tokenManager.getLocalToken().getSupCode();
        return courseRepo.findTCoursesBySupCodeAndStatus(supCode,"1");
    }

}

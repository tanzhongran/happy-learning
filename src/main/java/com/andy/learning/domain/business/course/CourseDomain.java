package com.andy.learning.domain.business.course;

import com.andy.learning.domain.entity.TCourse;

import java.util.List;

public interface CourseDomain {

    public void saveCourse(TCourse course) throws Exception;

    public List<TCourse> getCourseList();

}

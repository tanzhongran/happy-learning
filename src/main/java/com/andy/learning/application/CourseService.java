package com.andy.learning.application;

import com.andy.learning.domain.entity.TCourse;

import java.util.List;

public interface CourseService {

    public List<TCourse> getCourseList() throws Exception;

    public void saveCourse(TCourse course)throws Exception;

}

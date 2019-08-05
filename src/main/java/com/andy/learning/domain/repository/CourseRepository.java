package com.andy.learning.domain.repository;

import com.andy.learning.domain.entity.TCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<TCourse,Long> {

    public List<TCourse> findTCoursesBySupCodeAndStatus(String supCode,String status);

}

package com.andy.learning.domain.repository;

import com.andy.learning.domain.entity.TCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<TCourse,Long> {
}

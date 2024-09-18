package com.carlos_catano.challenge_cesde.repository;

import com.carlos_catano.challenge_cesde.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByPriceLessThan(BigDecimal price);
    List<Course> findByDuration(int duration);
}

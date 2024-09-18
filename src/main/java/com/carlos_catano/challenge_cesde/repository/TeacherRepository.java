package com.carlos_catano.challenge_cesde.repository;

import com.carlos_catano.challenge_cesde.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}

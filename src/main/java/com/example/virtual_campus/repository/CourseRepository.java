package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Course;
import com.example.virtual_campus.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Subject findByName(String name);
    List<Subject> findByCourse(Course course);
}

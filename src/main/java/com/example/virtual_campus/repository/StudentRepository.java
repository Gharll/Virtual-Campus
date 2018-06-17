package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByRollNumber(int rollNumber);
    Student findById(int id);
    Student findByActivationCode(String activationCode);
}

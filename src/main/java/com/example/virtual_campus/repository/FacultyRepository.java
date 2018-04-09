package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacultyRepository extends JpaRepository <Faculty, Long> {

}

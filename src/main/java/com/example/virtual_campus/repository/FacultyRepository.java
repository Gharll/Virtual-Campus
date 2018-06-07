package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("facultyRepository")
public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    Faculty findByFullName(String fullName);
    Faculty findByAbbreviationName(String abbreviationName);

}

package com.example.virtual_campus.repository;

import com.example.virtual_campus.model.Student;
import com.example.virtual_campus.model.UniversityRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UniversityRoleRepository")
public interface UniversityRoleRepository extends JpaRepository<UniversityRole, Long> {

    UniversityRole findByActivationCode(String activationCode);
}

package com.example.virtual_campus.Service.Interface;

import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.model.Student;

public interface IStudentService {

    Student findByRollNumber(int rollNumber);
    Student findById(int id);
    Student findByActivationCode(String activationCode);
    void save(Student student);
}

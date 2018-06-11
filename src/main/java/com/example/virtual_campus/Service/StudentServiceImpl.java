package com.example.virtual_campus.Service;

import com.example.virtual_campus.Service.Interface.IStudentService;
import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.model.Student;
import com.example.virtual_campus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student findByRollNumber(int rollNumber) {
        return studentRepository.findByRollNumber(rollNumber);
    }

    @Override
    public Student findById(int id){
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }
}

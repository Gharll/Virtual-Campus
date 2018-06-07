package com.example.virtual_campus.Service;

import com.example.virtual_campus.Service.Interface.ISubjectService;
import com.example.virtual_campus.model.Subject;
import com.example.virtual_campus.repository.SubjectRepository;
import com.example.virtual_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject findByName(String name) {
        return subjectRepository.findByName(name);
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }
}

package com.example.virtual_campus.Service.Interface;

import com.example.virtual_campus.model.Subject;

public interface ISubjectService {

    Subject findByName(String name);
    void save(Subject subject);
}

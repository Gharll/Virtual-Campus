package com.example.virtual_campus.Service;

import com.example.virtual_campus.Service.Interface.IFacultyService;
import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.repository.FacultyRepository;
import com.example.virtual_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FacultyServiceImpl implements IFacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public Faculty findByFullName(String fullName) {
        return facultyRepository.findByFullName(fullName);
    }

    @Override
    public Faculty findByAbbreviationName(String abbreviationName) {
        return facultyRepository.findByAbbreviationName(abbreviationName);
    }

    @Override
    public void save(Faculty faculty) {
        facultyRepository.save(faculty);
    }
}

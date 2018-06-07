package com.example.virtual_campus.Service.Interface;

import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.model.Subject;

public interface IFacultyService {

    Faculty findByFullName(String fullName);
    Faculty findByAbbreviationName(String abbreviationName);
    void save(Faculty faculty);
}

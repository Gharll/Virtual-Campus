package com.example.virtual_campus.controller;

import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class FacultyController {

    @Autowired
    private FacultyRepository repository;

    @ModelAttribute("faculties")
    public List<Faculty> faculties() {
        return repository.findAll();
    }
}

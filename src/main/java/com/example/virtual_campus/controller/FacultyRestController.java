package com.example.virtual_campus.controller;

import com.example.virtual_campus.exception.ResourceNotFoundException;
import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FacultyRestController implements ICrud<Faculty> {

    @Autowired
    private FacultyRepository repository;

    @Override
    @GetMapping("/faculties")
    public List<Faculty> getAll() {
        return repository.findAll();
    }

    @Override
    @PostMapping("/faculties")
    public Faculty create(@Valid Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    @GetMapping("get/faculties/{id}")
    public Faculty getById(@PathVariable(value = "id") Long id) {
        return findById(id);
    }

    @Override
    @PutMapping("put/faculties/{id}")
    public Faculty update(@PathVariable(value = "id") Long id,
                          @Valid  Faculty facultyDetails) {

        Faculty faculty = findById(id);
        faculty.setFullName(facultyDetails.getFullName());
        faculty.setAbbreviationName(facultyDetails.getAbbreviationName());
        return repository.save(faculty);
    }

    @Override
    @DeleteMapping("delete/faculties/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Faculty faculty = findById(id);
        repository.delete(faculty);
        return ResponseEntity.ok().build();
    }

    private Faculty findById(Long id){
       return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Faculty", "id", id));
    }
}

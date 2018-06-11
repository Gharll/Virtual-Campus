package com.example.virtual_campus.controller.RestController;

import com.example.virtual_campus.controller.RestController.Interface.ICrud;
import com.example.virtual_campus.exception.ResourceNotFoundException;
import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.model.Subject;
import com.example.virtual_campus.repository.FacultyRepository;
import com.example.virtual_campus.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SubjectRestController implements ICrud<Subject> {

    @Autowired
    private SubjectRepository repository;

    @Override
    @GetMapping("/subjects")
    public List<Subject> getAll() {
        return repository.findAll();
    }

    @Override
    @PostMapping("/subjects")
    public Subject create(@Valid Subject subject) {
        return repository.save(subject);
    }

    @Override
    @GetMapping("get/subjects/{id}")
    public Subject getById(@PathVariable(value = "id") Long id) {
        return findById(id);
    }

    @Override
    @PutMapping("put/subjects/{id}")
    public Subject update(@PathVariable(value = "id") Long id,
                          @Valid  Subject subjectDetails) {

        Subject subject = findById(id);

        subject.setDescription(subjectDetails.getDescription());
        subject.setEcts(subjectDetails.getEcts());
        subject.setName(subjectDetails.getName());
        subject.setOtherHours(subjectDetails.getOtherHours());
        subject.setLectureHours(subjectDetails.getLectureHours());
        subject.setProjectHours(subjectDetails.getProjectHours());
        subject.setSeminarHours(subjectDetails.getSeminarHours());
        subject.setTutorialsHours(subjectDetails.getTutorialsHours());
        subject.setCourse(subjectDetails.getCourse());

        return repository.save(subject);
    }

    @Override
    @DeleteMapping("delete/subjects/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Subject subject = findById(id);
        repository.delete(subject);
        return ResponseEntity.ok().build();
    }

    private Subject findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Subject", "id", id));
    }
}

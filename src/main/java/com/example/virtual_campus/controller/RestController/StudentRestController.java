package com.example.virtual_campus.controller.RestController;

import com.example.virtual_campus.controller.RestController.Interface.ICrud;
import com.example.virtual_campus.exception.ResourceNotFoundException;
import com.example.virtual_campus.model.Faculty;
import com.example.virtual_campus.model.Student;
import com.example.virtual_campus.model.Subject;
import com.example.virtual_campus.repository.FacultyRepository;
import com.example.virtual_campus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class StudentRestController implements ICrud<Student> {

    @Autowired
    private StudentRepository repository;


    @Override
    @GetMapping("/students")
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    @PostMapping("/students")
    public Student create(@Valid Student student) {
        return repository.save(student);
    }

    @Override
    @GetMapping("get/students/{id}")
    public Student getById(@PathVariable(value = "id") Long id) {
        return findById(id);
    }



    @GetMapping("get/students/activationCode/{id}")
    public String getActivationCodeById(@PathVariable(value = "id") Long id) {
        Student student = findById(id);
        return student.getActivationCode();

    }


    @Override
    @PutMapping("put/students/{id}")
    public Student update(@PathVariable(value = "id") Long id,
                          @Valid  Student studentDetails) {

        Student student = findById(id);
        student.setRollNumber(studentDetails.getRollNumber());
        return repository.save(student);
    }



    @Override
    @DeleteMapping("delete/students/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Student student = findById(id);
        repository.delete(student);
        return ResponseEntity.ok().build();
    }


    private Student findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student", "id", id));
    }
}

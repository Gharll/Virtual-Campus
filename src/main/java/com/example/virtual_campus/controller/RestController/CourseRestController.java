package com.example.virtual_campus.controller.RestController;

import com.example.virtual_campus.controller.RestController.Interface.ICrud;
import com.example.virtual_campus.exception.ResourceNotFoundException;
import com.example.virtual_campus.model.Course;
import com.example.virtual_campus.model.Course;
import com.example.virtual_campus.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseRestController implements ICrud<Course> {

    @Autowired
    private CourseRepository repository;


    @Override
    @GetMapping("/courses")
    public List<Course> getAll() {
        return repository.findAll();
    }

    @Override
    @PostMapping("/courses")
    public Course create(@Valid Course Course) {
        return repository.save(Course);
    }

    @Override
    @GetMapping("get/courses/{id}")
    public Course getById(@PathVariable(value = "id") Long id) {
        return findById(id);
    }

    @Override
    @PutMapping("put/courses/{id}")
    public Course update(@PathVariable(value = "id") Long id,
                          @Valid  Course courseDetails) {

        Course course = findById(id);

        course.setName(courseDetails.getName());
        course.setFaculty(courseDetails.getFaculty());
        return repository.save(course);
    }

    @Override
    @DeleteMapping("delete/courses/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Course course = findById(id);
        repository.delete(course);
        return ResponseEntity.ok().build();
    }

    private Course findById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Course", "id", id));
    }
}

package com.example.virtual_campus.Service;

import com.example.virtual_campus.Service.Interface.ICourseService;
import com.example.virtual_campus.model.Course;
import com.example.virtual_campus.repository.CourseRepository;
import com.example.virtual_campus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }
}

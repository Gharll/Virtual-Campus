package com.example.virtual_campus.controller.RestController;

import com.example.virtual_campus.model.Student;
import com.example.virtual_campus.model.User;
import com.example.virtual_campus.repository.StudentRepository;
import com.example.virtual_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.Valid;

public class ActivationRestController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @PutMapping("put/active/students/{activationCode}")
    public Student update(@PathVariable(value = "activationCode") String activationCode,
                          @Valid Student studentDetails) {

        Student student = studentRepository.findByActivationCode(activationCode);

        UserDetails userDetails =
                (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getUsername());

        student.setActive(true);
        student.setUser(user);

        return studentRepository.save(student);
    }
}

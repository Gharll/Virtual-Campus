package com.example.virtual_campus.controller.RestController;

import com.example.virtual_campus.model.Subject;
import com.example.virtual_campus.model.User;
import com.example.virtual_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoggedUserRestController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/user")
    public User get() {
        UserDetails userDetails =
                (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = repository.findByEmail(userDetails.getUsername());

        return user;
    }
}

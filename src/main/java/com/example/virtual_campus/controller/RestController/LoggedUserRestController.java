package com.example.virtual_campus.controller.RestController;

import com.example.virtual_campus.model.Subject;
import com.example.virtual_campus.model.UniversityRole;
import com.example.virtual_campus.model.User;
import com.example.virtual_campus.repository.UniversityRoleRepository;
import com.example.virtual_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoggedUserRestController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UniversityRoleRepository universityRole;

    @GetMapping("/user")
    public Map<String,Object> get() {
        Map <String, Object> map = new HashMap<>();
        UserDetails userDetails =
                (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = repository.findByEmail(userDetails.getUsername());
        map.put("user", user);

        List<UniversityRole> universityRoles = universityRole.findByUser(user);
        map.put("universityRoles", universityRoles);

        return map;
    }
}

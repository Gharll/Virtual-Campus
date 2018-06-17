package com.example.virtual_campus.controller.RestController;

import com.example.virtual_campus.model.Student;
import com.example.virtual_campus.model.UniversityRole;
import com.example.virtual_campus.model.User;
import com.example.virtual_campus.repository.StudentRepository;
import com.example.virtual_campus.repository.UniversityRoleRepository;
import com.example.virtual_campus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ActivationRestController {

    @Autowired
    private UniversityRoleRepository universityRoleRepository;

    @Autowired
    private UserRepository userRepository;

    @PutMapping("put/active/{activationCode}")
    public ResponseEntity update(@PathVariable(value = "activationCode") String activationCode,
                                 @Valid Student studentDetails) {

        UniversityRole universityRole = universityRoleRepository.findByActivationCode(activationCode);
        if(universityRole != null && !universityRole.isActive()){
            UserDetails userDetails =
                    (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByEmail(userDetails.getUsername());

            universityRole.setActive(true);
            universityRole.setUser(user);

            universityRoleRepository.save(universityRole);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

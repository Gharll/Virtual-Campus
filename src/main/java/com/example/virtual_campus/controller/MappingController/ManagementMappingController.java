package com.example.virtual_campus.controller.MappingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/management")
public class ManagementMappingController {

    @GetMapping("/faculties")
    public String faculties(){
        return "/management/faculties-management";
    }

    @GetMapping("/subjects")
    public String subjects(){
        return "/management/subjects-management";
    }

    @GetMapping("/students")
    public String students(){
        return "/management/students-management";
    }

    @GetMapping("/courses")
    public String courses(){
        return "/management/courses-management";
    }
}

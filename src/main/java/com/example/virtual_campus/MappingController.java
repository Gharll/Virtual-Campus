package com.example.virtual_campus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MappingController {

    //Index

    @GetMapping("/index")
    public String blank(){
        return "index";
    }

    //Management

    @GetMapping("/management/faculties")
    public String faculties(){
        return "management/faculties";
    }

    @GetMapping("/management/subjects")
    public String subjects(){
        return "management/subjects";
    }

    @GetMapping("/management/students")
    public String students(){
        return "management/students";
    }

    @GetMapping("/management/courses")
    public String courses(){
        return "management/courses";
    }


    //Profile and Settings

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/settings")
    public String settings(){
        return "settings";
    }


    //Error

    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }
}

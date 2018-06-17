package com.example.virtual_campus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MappingController {

    @GetMapping("/index")
    public String blank(){
        return "index";
    }

    @GetMapping("/faculties")
    public String faculties(){
        return "faculties";
    }

    @GetMapping("/subjects")
    public String subjects(){
        return "subjects";
    }

    @GetMapping("/students")
    public String students(){
        return "students";
    }

    @GetMapping("/courses")
    public String courses(){
        return "courses";
    }

    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/settings")
    public String settings(){
        return "settings";
    }

    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }
}

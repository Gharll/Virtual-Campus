package com.example.virtual_campus.controller.MappingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

    @GetMapping("/index")
    public String blank(){
        return "index";
    }
    @GetMapping("/profile")
    public String profile(){
        return "profile";
    }

    @GetMapping("/settings")
    public String settings(){
        return "settings";
    }



    @GetMapping("/subjects")
    public String subjects(){
        return "subjects";
    }

}

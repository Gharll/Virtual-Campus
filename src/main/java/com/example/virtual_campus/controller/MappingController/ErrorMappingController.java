package com.example.virtual_campus.controller.MappingController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorMappingController {

    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }
}

package com.example.virtual_campus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

    /*
    @GetMapping("/login")
    public String login(){
        return "login";
    }*/

    /*
    @GetMapping("/register")
    public String register(){
        return "registration";
    }
*/
    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }
}

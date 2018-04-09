package com.example.virtual_campus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/blank")
    public String blank(){
        return "blank";
    }

    @GetMapping("faculties")
    public String faculties(){
        return "faculties";
    }
}

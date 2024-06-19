package com.green.DataPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScoreController {

    @GetMapping("/inputName")
    public String inputName(){
        return "inputName";
    }

    @PostMapping("/info")
    public String stuInfo(){
        return "stuInfo";
    }

    @PostMapping("/inputScore")
    public String inputScore(){
        return "inputScore";
    }

    @PostMapping("/student")
    public String student(){
        return "student";
    }


}

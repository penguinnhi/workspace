package com.green.SecurityTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String main(){
        return "뿡";
    }

    @GetMapping("/test")
    public String test(){
        return "빵";
    }







}

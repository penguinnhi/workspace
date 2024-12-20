package com.green.DataPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ATagController {

    @GetMapping("/a1")
    public String a1(Model model){
        model.addAttribute("stuName","jiji");
        model.addAttribute("score",80);
        return "a1";
    }

    @GetMapping("/a2")
    public String a2(@RequestParam(name="address") String name, Model model){
        System.out.println(name);
        model.addAttribute(name);
        return "a2";
    }

    @GetMapping("/a3")
    public String a3(@RequestParam(name="name") String n,@RequestParam(name="age") String age){
        System.out.println(n);
        System.out.println(age);
        return "a3";
    }



}

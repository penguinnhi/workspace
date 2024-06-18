package com.green.SpringFirst;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController { //해석함

    @GetMapping("/a")
    public String goFirst(){
        return "first"; //first.html을 실행하겟읍니다
    }

    @GetMapping("/b")
    public String goSecond(){
        System.out.println(11);
        return "second";
    }

    @GetMapping("/c")
    public String goThird(){
        System.out.println(22);
        return "third";
    }

    @GetMapping("/login")
    public String goLogin(){
        return "login";
    }

    @GetMapping("/loginResult")
    public String loginResult(){
        System.out.println("loginResult 메서드 실행");
        return "";
    }

}

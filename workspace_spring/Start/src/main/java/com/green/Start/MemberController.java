package com.green.Start;


import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class MemberController {

    //1. 자바에서 html로 데이터를 전달하기 위해서는 실행되는 메서드의 매개변수의 Model 인터페이스 객체를 선언
    //2. 객체명.addAttribute 메서드를 사용하여 데이터를 전달한다
    @GetMapping("/main")
    public String goMain(Model model){
        model.addAttribute("name","java"); // ( 전달되는 이름, 실제로 전달되는 데이터 )
        model.addAttribute("age",10);
        return "main";
    }

    @GetMapping("/login")
    public String goLogin(Model model){
        String[] hobbies={"독서","운동","공부"};
        model.addAttribute("hobbies",hobbies); //html에서도 배열처럼 출력을 해야함

        Member m= new Member("김수한무",20,200);
        model.addAttribute("member",m);


        return "test_login";
    }

    @GetMapping("/join")
    public String goJoin(Model model){
        List<Member> list=new ArrayList<>();

        Member m1=new Member("김수한무",20,200);
        Member m2=new Member("두루미",30,300);
        Member m3=new Member("거북이",100,500);

        list.add(m1);
        list.add(m2);
        list.add(m3);

        model.addAttribute("List",list);



        return "test_join";
    }

}

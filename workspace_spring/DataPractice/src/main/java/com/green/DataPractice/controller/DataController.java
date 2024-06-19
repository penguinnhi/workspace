package com.green.DataPractice.controller;

import com.green.DataPractice.vo.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {

    //인터넷창에 localhost:8080/loginForm 으로 접속하면 실행
    @GetMapping("/loginForm")
    public String loginForm(){
        return "login";
    }

    //form 태그 ****** 로 전달되는 데이터를 받을 때 매개변수를 사용한다.
    //매개변수에 @RequestParam 을 사용하여 데이터를 받을 수 있다.
    //@RequestParam(name = "이름" ) : "이름"은 전달되는 input 태그의 name 속성 값

    @PostMapping("/login")
    public String login(@RequestParam(name = "id") String id, @RequestParam(name = "pw") String pw){
        // name=id 는 html의 input 태그의 name 속성이 id인 이름인 거를 받겠다는 거
        System.out.println("id : "+id);
        System.out.println("pw : "+pw);
        return "login_result";
    }


    //html에서 전달되는 데이터의 이름(input 태그의 name 속성값)과
    //매개변수로 전달된 클래스의 멤버변수명이 일치하면
    //html에서 넘어온 데이터를 객체에 자동으로 저장해줌
    //이때 클래스에는 반드시 getter, setter가 생성되어 있어야 함.
    //이렇게 html에서 넘어온 데이터를 받기 위해 컨트롤러안의 메서드에서 매개변수로 활용하는 객체를 커맨드 객체(LoginVO)라고 지칭함

    @PostMapping("/login1") //login1이라는 요청경로가 들어오면 이 메서드를 실행한다
    public String login1(LoginVO loginVO, Model model){ // 객체로 데이터 전달받기

        model.addAttribute("loginInfo",loginVO);

        System.out.println("춥습니다");
        System.out.println("id = "+loginVO.getId());
        System.out.println("pw = "+loginVO.getPw());

        return "login_result";
    }



}

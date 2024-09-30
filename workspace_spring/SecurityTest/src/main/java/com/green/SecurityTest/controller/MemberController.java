package com.green.SecurityTest.controller;

import com.green.SecurityTest.service.MemberService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    // 의존성 주입 방식 : 생성자 주입(적극 권장), setter 주입, 필드 주입

    // 필드 주입 : 이해하기는 쉬우나 ( Spring 공식 문서에서 ) 권장하지 않는 방식
//    @Resource(name="memberService")
    private final MemberService memberService;
//     final : 한 번 변한 값은 다시 변하지 않음 (코드의 안정성)


    // 생성자 주입 방식 : lombok 이랑 같이 씀
    // 클래스에 생성자가 하나라면 autowired 어노테이션이 생략 가능
//    @Autowired // 객체 중에서 만든 객체와 자료형이 일치하면
//    public MemberController(MemberService memberService){
//        this.memberService=memberService;
//    }



    // 로그인 할 수 있는 페이지로 이동
    @GetMapping("/loginForm")
    public String loginForm(){

        return "loginForm";
    }

    // 회원가입 페이지로 이동
    @GetMapping("/joinForm")
    public String joinForm(){

        return "joinForm";
    }




}

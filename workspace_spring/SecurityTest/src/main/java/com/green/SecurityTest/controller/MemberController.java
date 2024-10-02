package com.green.SecurityTest.controller;

import com.green.SecurityTest.service.MemberService;
import com.green.SecurityTest.vo.MemberVO;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor // @RequiredArgsConstructor + final
public class MemberController {
    // 의존성 주입 방식 : 생성자 주입(적극 권장), setter 주입, 필드 주입

    // 필드 주입 : 이해하기는 쉬우나 ( Spring 공식 문서에서 ) 권장하지 않는 방식
//    @Resource(name="memberService")
    private final MemberService memberService;
//     final : 한 번 변한 값은 다시 변하지 않음 (코드의 안정성)
    private final PasswordEncoder passwordEncoder;

    // 생성자 주입 방식 : lombok 이랑 같이 씀
    // 클래스에 생성자가 하나라면 autowired 어노테이션이 생략 가능
//    @Autowired // 객체 중에서 만든 객체와 자료형이 일치하면
//    public MemberController(MemberService memberService){
//        this.memberService=memberService;
//    }



    // 로그인 할 수 있는 페이지로 이동
    @GetMapping("/loginForm")
    public String loginForm(){
        String name = "java";

        // name 변수값을 암호화
        String encodedName=passwordEncoder.encode(name);
        System.out.println("1 : "+encodedName);

        String encodedName1=passwordEncoder.encode(name);
        System.out.println("2 : "+encodedName1);

        // 첫번째 매개변수 : 암호화 되지 않은 데이터
        // 두번째 매개변수 : 암호화 된 데이터
        // 원본 데이터랑 암호화된 데이터랑 같은 것인지?
        boolean result1 = passwordEncoder.matches("java",encodedName);
        boolean result2 = passwordEncoder.matches("java",encodedName1);
        boolean result3 = passwordEncoder.matches("java1",encodedName);
        System.out.println("R1 : "+result1);
        System.out.println("R2 : "+result2);
        System.out.println("R3 : "+result3);

        return "loginForm";
    }

    // 회원가입 페이지로 이동
    @GetMapping("/joinForm")
    public String joinForm(){

        return "joinForm";
    }

    // 회원가입
    @PostMapping("/join")
    public String join(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);

        // 비밀번호 암호화
        String encodedPw = passwordEncoder.encode(memberVO.getMemPw());
        memberVO.setMemPw(encodedPw);

        //기본 권한
        memberVO.setMemRole("USER");

        memberService.join(memberVO);

        return "회원가입 성공";
    }




}

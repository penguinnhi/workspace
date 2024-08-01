package com.green.Shop_me.member.controller;

import com.green.Shop_me.member.service.MemberService;
import com.green.Shop_me.member.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource(name="memberService")
    private MemberService memberService;


    @PostMapping("/insert")
    public void insertMember(@RequestBody MemberVO memberVO){
//        System.out.println("?");
        memberService.insertMem(memberVO);
    }

    @GetMapping("/isDup/{inputId}")
    public boolean isDup(@PathVariable("inputId")String inputId){
//      true 중복 false 가입가능
        return memberService.isDup(inputId);
    }



}

package com.green.Board.controller;

import com.green.Board.service.MemberService;
import com.green.Board.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource(name="memberService")
    private MemberService memberService;

    @PostMapping("/getReg")
    public void getReg(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);
        memberService.legMember(memberVO);
    }

    @GetMapping("/logIn")
    public MemberVO logIn(@RequestBody MemberVO memberVO){
        return memberService.logInMember(memberVO);
    }


}

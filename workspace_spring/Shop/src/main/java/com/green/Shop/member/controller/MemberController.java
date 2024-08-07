package com.green.Shop.member.controller;

import com.green.Shop.member.service.MemberService;
import com.green.Shop.member.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource(name="memberService")
    private MemberService memberService;


    @PostMapping("/join")
    public void goJoin(@RequestBody MemberVO memberVO){
        memberService.goJoin(memberVO);
    }

    @GetMapping("/isDup/{inputId}")
    public boolean isDup(@PathVariable("inputId")String inputId){
        return memberService.isDup(inputId);
    }

    @PutMapping("/goLogin")
    public MemberVO goLogin(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);
        return memberService.goLogin(memberVO);
    }


}

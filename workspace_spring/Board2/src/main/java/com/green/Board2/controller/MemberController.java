package com.green.Board2.controller;


import com.green.Board2.service.MemberService;
import com.green.Board2.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource(name="memberService")
    private MemberService memberService;

    @PostMapping("/join")
    public void joinMem(@RequestBody MemberVO memberVO){
        memberService.joinMem(memberVO);
    }

    @GetMapping("/isDup/{inputId}")
    public boolean isDup(@PathVariable("inputId")String inputId){
        return memberService.isDup(inputId);
    }

}

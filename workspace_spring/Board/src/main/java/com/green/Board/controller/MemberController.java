package com.green.Board.controller;

import com.green.Board.service.MemberService;
import com.green.Board.vo.MemberVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로그 남길 때 쓰는 어노테이션
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource(name="memberService")
    private MemberService memberService;

    @PostMapping("/getReg")
    public void getReg(@RequestBody MemberVO memberVO){
//        log.info("!!!!!!!!!!!!!!!!!!!가입메소드!!!!!!!!!!!!!");
//        log.info(memberVO.toString());
        memberService.legMember(memberVO);
    }

    @PostMapping("/logIn")
    public MemberVO logIn(@RequestBody MemberVO memberVO){

        //조회된 데이터가 없으면 member는 null이 된다
        return memberService.logInMember(memberVO);
    }

    @GetMapping("/list")
    public List<MemberVO> getMemList(){
        return memberService.getMemList();
    }

    //true 중복 회원가입안됨 false 중복아님 가입됨
    @GetMapping("/isDup/{inputId}")
    public boolean isDup(@PathVariable("inputId")String inputId){
//        log.info("java!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        return memberService.isDup(inputId);
    }


}

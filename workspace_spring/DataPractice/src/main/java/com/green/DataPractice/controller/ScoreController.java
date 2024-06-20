package com.green.DataPractice.controller;

import com.green.DataPractice.vo.StuInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScoreController {

    //시작 페이지로 이동 1
    @GetMapping("/inputName")
    public String inputName(){
        return "inputName";
    }

    //첫번재 페이지에서 넘어온 데이터를 받아, 두번째 페이지로 이동 2
    @PostMapping("/info")
    public String stuInfo(StuInfoVO stuInfoVO){
        System.out.println(stuInfoVO);

        return "stuInfo";
    }

    // 3 세번째 페이지로 이동
    @PostMapping("/inputScore")
    public String inputScore(StuInfoVO stuInfoVO){
        System.out.println(stuInfoVO);

        return "inputScore";
    }

    //네번째 페이지로 이동
    @PostMapping("/student")
    public String student(StuInfoVO stuInfoVO,Model model){
        System.out.println(stuInfoVO);

        double avg=(stuInfoVO.getKorScore()+stuInfoVO.getEngScore()+stuInfoVO.getMathScore())/3.0;
        model.addAttribute("avg",avg); //*********

        return "student";
    }


}

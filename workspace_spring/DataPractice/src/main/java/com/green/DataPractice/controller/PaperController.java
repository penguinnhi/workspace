package com.green.DataPractice.controller;

import com.green.DataPractice.vo.RegInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PaperController {

    @GetMapping("/reg")
    public String regPaper(){
        return "reg";
    }

    @PostMapping("/reg_info")
    public String regInfo(RegInfoVO regInfoVO){
        System.out.println(regInfoVO);
        return "reg_info";
    }

    @PostMapping("/see_reg")
    public String seeReg(RegInfoVO regInfoVO){
        System.out.println(regInfoVO);
        return "see_reg";
    }


}

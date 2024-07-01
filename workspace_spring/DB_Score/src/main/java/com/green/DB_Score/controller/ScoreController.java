package com.green.DB_Score.controller;

import com.green.DB_Score.service.ScoreServiceImpl;
import com.green.DB_Score.vo.StudentVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;

@Controller
public class ScoreController {
    @Resource(name="scoreService")
    private ScoreServiceImpl scoreService;

    @GetMapping("/") //학생정보 목록페이지
    public String student(Model model){

        //학생 목록 데이터를 DB에서 조회
        List<StudentVO> stuList=scoreService.getStuList();


        model.addAttribute("stuList",stuList);

        return "stu_list";
    }

    @PostMapping("/regStudent") //학생 등록 페이지로 가는길
    public String regStudent(){


        return "reg_student";
    }

    @PostMapping("/regList")
    public String regList(StudentVO studentVO,Model model){ //등록하고 목록페이지로 감
        StudentVO stu=new StudentVO();
        stu.setStuNum(studentVO.getStuNum());
        stu.setStuName(studentVO.getStuName());
        stu.setKorScore(studentVO.getKorScore());
        stu.setEngScore(studentVO.getEngScore());
        stu.setIntro(studentVO.getIntro());
        //여기서 등록하는지 ??
        scoreService.insert(stu);

        //ㅇㅇ 등록됨 이걸 html로 보내야함
        model.addAttribute(studentVO);
        //
        return "redirect:/";
    }

    @GetMapping("/studentDetail")
    public String studentDetail(@RequestParam(name="stuNum")int stuNum,StudentVO studentVO,Model model){ // 상세페이지로 가는 길
        StudentVO su=scoreService.selectDetail(stuNum);
        model.addAttribute("student",su);

        return "student_detail";
    }


    @GetMapping("/deleteStu")
    public String deleteStu(StudentVO studentVO){//학생 삭제
        scoreService.delete(studentVO);

        return "redirect:/";
    }


    @GetMapping("/updateStu")
    public String updateStu(StudentVO studentVO,Model model,@RequestParam(name="stuNum")int stuNum){ //수정페이지로 가는길

        model.addAttribute(studentVO); //원래정보
        StudentVO student=scoreService.selectDetail(stuNum); //학번 받아서 한명 픽함
        model.addAttribute("student",student); //픽한 학생 정보 보내

        return "update_student";
    }

    @PostMapping("/updateList")
    public String updateList(StudentVO studentVO,Model model,@RequestParam(name="stuNum")int stuNum){ //수정하고 상세페이지 가는길
        //StudentVO stu=scoreService.selectDetail(stuNum); //픽한학생
        /*stu.setStuNum(studentVO.getStuNum());
        stu.setStuName(studentVO.getStuName());
        stu.setKorScore(studentVO.getKorScore());
        stu.setEngScore(studentVO.getEngScore());
        stu.setIntro(studentVO.getIntro());*/
        scoreService.update(studentVO); //수정

        //수정한걸 html로 보내기 > 커맨드 객체는 알아서 html로 감
        //model.addAttribute("student",stu);

        //수정은 됐는데 페이지 오류가 뜸
        // ㄴ 자바에서 자바로 갈때는 ↓
        return "redirect:/studentDetail?stuNum="+studentVO.getStuNum(); //????**************
    }



}

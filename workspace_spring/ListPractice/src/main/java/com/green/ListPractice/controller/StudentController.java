package com.green.ListPractice.controller;

import com.green.ListPractice.service.StudentService;
import com.green.ListPractice.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    StudentService studentService=new StudentService();


    @GetMapping("/stulist") // 목록
    public String stulist(Model model,StudentVO studentVO){
        //model.addAttribute("stuList",stuList);
        //학생 목록데이터를 html로 전달해야지 html에서 이 리스트 데이터를 사용가능함


        //학생 목록 데이터 받아오기
        List<StudentVO> list = studentService.getStuList();

        //학생 목록을 html로 전달하기
        model.addAttribute("stuList",list);


        return "stu_list";
    }

    @GetMapping("/regstudent") //등록페이지
    public String regstudent(StudentVO studentVO){
        //System.out.println(studentVO);

        //stuList.add(studentVO); // 등록됨?


         //? 등록한거 보내?

        return "reg_student";
    }

    @PostMapping("/relist") //학생 등록하고 다시 목록페이지로
    public String relist(StudentVO studentVO, Model model){
        System.out.println(studentVO);
        //stuList.add(studentVO); // ?된건가? ㅇㅇ

        studentService.regStudent(studentVO);

        return "redirect:/stulist";
    }



    @GetMapping("/updatestu") // 학생정보 수정 페이지로 가는길
    public String updatestu(StudentVO studentVO,@RequestParam(name="detail")int detail,Model model){
        model.addAttribute(studentVO);
        //정보를 수정할 학생의 원래 정보를 html에 전달
        //1. 정보를 수정할 학생 한 명을 픽해야함
        StudentVO student = studentService.getStuDetail(studentVO,detail);
        //2. 수정할 학생을 html으로 보내기
        model.addAttribute("student",student);


        return "update_student";
    }


    @PostMapping("/uprelist")//수정 후 상세페이지으로
    public String uprelist(StudentVO studentVO,Model model){

        //수정한걸 받아
        studentService.updateStu(studentVO);
        System.out.println(studentVO);



        //model.addAttribute("student",studentVO); 자바에서 html로 보낼때 쓰는거
        //우리는 자바에서 자바로 갈거임
        return "redirect:/studentdetail?detail="+studentVO.getStuNum(); //**************** ?????

    }




    @GetMapping("/studentdetail") // 상세페이지가기
    public String stuDetail(StudentVO studentVO,Model model,@RequestParam(name="detail")int detail){

        StudentVO de = studentService.getStuDetail(studentVO,detail);

        model.addAttribute("student",de);

        return "student_detail";

    }



    // 학생 삭제 + 목록페이지 고
    @GetMapping("/delstu")
    public String delStu(StudentVO studentVO,@RequestParam(name="detail")int detail,Model model){

        //StudentVO del = studentService.delStu(studentVO,detail);

        //model.addAttribute("student",del);

        studentService.delStu(detail);
        model.addAttribute("student",detail);

        return "redirect:/stulist";
    }





}

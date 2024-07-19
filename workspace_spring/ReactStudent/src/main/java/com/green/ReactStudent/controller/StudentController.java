package com.green.ReactStudent.controller;

import com.green.ReactStudent.service.StuService;
import com.green.ReactStudent.vo.StudentVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Resource(name="stuService")
    private StuService stuService;

    @GetMapping("/getList")
    public List<StudentVO> getList(){
        return stuService.getList();
    }

    @GetMapping("/getDetail/{stuNum}")
    public StudentVO getDetail(@PathVariable("stuNum")int stuNum){
        return stuService.getDetail(stuNum);
    }
    
    @PostMapping("/regStu")
    public void regStu(@RequestBody StudentVO studentVO){
        stuService.regStu(studentVO);
    }

    @DeleteMapping("/goDelete/{stuNum}")
    public void delStu(@PathVariable("stuNum")int stuNum){
        System.out.println(stuNum);
        stuService.delStu(stuNum);
    }

    @PutMapping("/inputScore")
    public void inputScore(@RequestBody StudentVO studentVO){

        stuService.inputScore(studentVO);
    }






}

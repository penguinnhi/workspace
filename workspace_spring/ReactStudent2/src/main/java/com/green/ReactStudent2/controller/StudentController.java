package com.green.ReactStudent2.controller;

import com.green.ReactStudent2.service.StudentService;
import com.green.ReactStudent2.vo.StudentVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Resource(name="studentService")
    private StudentService studentService;

    @GetMapping("/getList")
    public List<StudentVO> getList(){
        return studentService.getList();
    }

    @PostMapping("/insertStu")
    public void insertStu(@RequestBody StudentVO studentVO){
        studentService.insertStu(studentVO);
    }

    @GetMapping("/getDetail/{stuNum}")
    public StudentVO getDetail(@PathVariable("stuNum")int stuNum){
        return studentService.getDetail(stuNum);
    }

    @DeleteMapping("/delStu/{stuNum}")
    public void delStu(@PathVariable("stuNum")int stuNum){
        studentService.delStu(stuNum);
    }

    @PutMapping("/updateScore")
    public void updateScore(@RequestBody StudentVO studentVO){
        studentService.updateScore(studentVO);
    }



}

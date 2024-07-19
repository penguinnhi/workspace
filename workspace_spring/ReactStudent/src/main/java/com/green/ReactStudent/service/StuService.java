package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StudentVO;

import java.util.List;

public interface StuService {

    List<StudentVO> getList();

    StudentVO getDetail(int stuNum);

    void regStu(StudentVO studentVO);

    void delStu(int stuNum);

    void inputScore(StudentVO studentVO);
}

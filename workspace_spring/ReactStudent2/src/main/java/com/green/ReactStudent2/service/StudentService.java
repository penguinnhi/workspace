package com.green.ReactStudent2.service;

import com.green.ReactStudent2.vo.StudentVO;

import java.util.List;

public interface StudentService {

    List<StudentVO> getList();

    void insertStu(StudentVO studentVO);

    StudentVO getDetail(int stuNum);

    void delStu(int stuNum);

    void updateScore(StudentVO studentVO);
}

package com.green.DB_Score.service;

import com.green.DB_Score.vo.StudentVO;

import java.lang.reflect.Member;
import java.util.List;

public interface ScoreService {



    //학생등록
    void insert(StudentVO studentVO);

    //학생수정
    void update(StudentVO studentVO);

    //학생삭제
    void delete(StudentVO studentVO);

    //학생목록조회
    List<StudentVO> getStuList();

    //학생 상세 조회
    StudentVO selectDetail(int stuNum);


}

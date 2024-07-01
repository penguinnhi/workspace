package com.green.DB_Score.service;

import com.green.DB_Score.vo.StudentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    //학생 등록
    @Override
    public void insert(StudentVO studentVO) {
        sqlSession.insert("scoreMapper.insert",studentVO);

    }

    //학생 수정
    @Override
    public void update(StudentVO studentVO) {
        sqlSession.update("scoreMapper.update",studentVO);

    }

    //학생 삭제
    @Override
    public void delete(StudentVO studentVO) {
        sqlSession.delete("scoreMapper.delete",studentVO);

    }

    //학생목록조회
    @Override
    public List<StudentVO> getStuList() {
        List<StudentVO> list=sqlSession.selectList("scoreMapper.getStuList");

        return list;
    }

    //학생 상세조회
    @Override
    public StudentVO selectDetail(int stuNum) {
        StudentVO student=sqlSession.selectOne("scoreMapper.selectDetail",stuNum);

        return student;
    }














}

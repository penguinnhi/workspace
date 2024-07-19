package com.green.ReactStudent2.service;

import com.green.ReactStudent2.vo.StudentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<StudentVO> getList() {
        return sqlSession.selectList("studentMapper.getList");
    }

    @Override
    public void insertStu(StudentVO studentVO) {
        sqlSession.insert("studentMapper.insert1",studentVO);
    }

    @Override
    public StudentVO getDetail(int stuNum) {
        return sqlSession.selectOne("studentMapper.getDetail",stuNum);
    }

    @Override
    public void delStu(int stuNum) {
        sqlSession.delete("studentMapper.delStu",stuNum);
    }

    @Override
    public void updateScore(StudentVO studentVO) {
        sqlSession.update("studentMapper.score",studentVO);
    }
}

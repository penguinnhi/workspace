package com.green.ReactStudent.service;

import com.green.ReactStudent.vo.StudentVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stuService")
public class StuServiceImpl implements StuService {
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<StudentVO> getList() {
        return sqlSession.selectList("studentMapper.getList");
    }

    @Override
    public StudentVO getDetail(int stuNum) {
        return sqlSession.selectOne("studentMapper.getDetail",stuNum);
    }

    @Override
    public void regStu(StudentVO studentVO) {
        sqlSession.insert("studentMapper.insert1",studentVO);
    }

    @Override
    public void delStu(int stuNum) {
        sqlSession.delete("studentMapper.delete1",stuNum);
    }

    @Override
    public void inputScore(StudentVO studentVO) {
        sqlSession.insert("studentMapper.inputScore",studentVO);
    }

}

package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("axiosService")
public class AxiosServiceImpl implements AxiosService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<BoardVO> getSelect() {
        return sqlSession.selectList("axiosMapper.select1");
    }

    @Override
    public void insert1() {
        sqlSession.insert("axiosMapper.insert1");
    }


}

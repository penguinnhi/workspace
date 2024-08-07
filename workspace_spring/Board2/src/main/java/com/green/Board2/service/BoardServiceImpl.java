package com.green.Board2.service;

import com.green.Board2.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<BoardVO> getAllList() {
        return sqlSession.selectList("boardMapper.getAllList");
    }
}

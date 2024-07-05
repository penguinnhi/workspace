package com.green.BasicBoard3.service;

import com.green.BasicBoard3.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override //전체 게시글 조회
    public List<BoardVO> getAllList() {

        return sqlSession.selectList("boardMapper.getAllList");
    }

    @Override //게시글 등록
    public void insert(int boardNum) {
        sqlSession.insert("boardMapper.insert");

    }


}

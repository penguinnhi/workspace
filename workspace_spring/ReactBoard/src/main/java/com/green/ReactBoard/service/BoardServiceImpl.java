package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.BoardVO;
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

        return sqlSession.selectList("boardMapper.getBoardList");
    }

    @Override
    public BoardVO getDetail(int boardNum) {

        return sqlSession.selectOne("boardMapper.getDetail",boardNum);
    }

    @Override
    public void writeBoard(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insert1",boardVO);
    }

    @Override
    public void deleteBoard(int boardNum) {
        sqlSession.delete("boardMapper.delete1",boardNum);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        sqlSession.update("boardMapper.update1",boardVO);
    }


}

package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<BoardVO> getList() {
        return sqlSession.selectList("boardMapper.getList");
    }

    @Override
    public BoardVO getDetail(int boardNum) {
        return sqlSession.selectOne("boardMapper.getDetail",boardNum);
    }

    @Override
    public void updateBoard(BoardVO boardVO) {
        sqlSession.update("boardMapper.updateBoard",boardVO);
    }

    @Override
    public void insertBoard(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insertBoard",boardVO);
    }

    @Override
    public void delBoard(int boardNum) {
        sqlSession.delete("boardMapper.delBoard",boardNum);
    }

    @Override
    public String selectAll(int boardNum) {
        return "";
    }
}

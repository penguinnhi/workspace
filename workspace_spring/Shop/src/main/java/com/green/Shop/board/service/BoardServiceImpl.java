package com.green.Shop.board.service;


import com.green.Shop.board.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void insertBoard(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insertBoard",boardVO);
    }

    @Override
    public List<BoardVO> getMyBoard(String memId) {
        return sqlSession.selectList("boardMapper.selectMyBoard",memId);
    }

    @Override
    public void updateMyBoard(BoardVO boardVO) {
        sqlSession.update("boardMapper.updateMyBoard",boardVO);
    }

    @Override
    public List<BoardVO> getAdminBoard() {
        return sqlSession.selectList("boardMapper.selectAdminBoard");
    }

    @Override
    public BoardVO getMyBoardDetail(int boardNum) {
        return sqlSession.selectOne("boardMapper.myBoardDetail",boardNum);
    }

    @Override
    public void delMyBoard(int boardNum) {
        sqlSession.delete("boardMapper.delMyBoard",boardNum);
    }
}

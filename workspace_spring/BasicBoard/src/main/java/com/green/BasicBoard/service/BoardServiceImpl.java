package com.green.BasicBoard.service;

import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    //학생 목록 조회
    @Override
    public List<BoardVO> getBoardList(SearchVO searchVO) {

        return sqlSession.selectList("boardMapper.selectList",searchVO);
    }

    //상세조회
    @Override
    public BoardVO selectDetail(int boardNum) {
        return sqlSession.selectOne("boardMapper.selectDetail",boardNum);
    }

    @Override
    public void write(BoardVO boardVO) { //글 작성
        sqlSession.insert("boardMapper.insert",boardVO);
    }

    @Override
    public void update(BoardVO boardVO) { //글 수정
        sqlSession.update("boardMapper.update",boardVO);

    }

    @Override
    public void delete(BoardVO boardVO) { //글 삭제
        sqlSession.delete("boardMapper.delete",boardVO);

    }

    //검색
    @Override
    public List<BoardVO> search(SearchVO searchVO) {
        return sqlSession.selectList("boardMapper.search",searchVO);
    }

    //조회수 증가
    @Override
    public void updateReadCnt(int boardNum) {
        sqlSession.update("boardMapper.updateReadCnt",boardNum);
    }



}

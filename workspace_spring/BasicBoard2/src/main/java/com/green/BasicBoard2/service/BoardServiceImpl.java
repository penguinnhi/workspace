package com.green.BasicBoard2.service;

import com.green.BasicBoard2.vo.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override //전체조회
    public List<BoardVO> getBoardList() {
        return sqlSession.selectList("boardMapper.selectAll");
    }

    @Override //상세조회
    public BoardVO getBoardDetail(int boardNum) {
        return sqlSession.selectOne("boardMapper.selectDetail",boardNum);
    }

    @Override //게시글 등록
    public void write(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insert",boardVO);

    }

    @Override //게시글 삭제
    public void delete(int boardNum) {
        sqlSession.delete("boardMapper.delete",boardNum);

    }

    @Override //게시글 수정
    public void update(BoardVO boardVO) {
        sqlSession.update("boardMapper.update",boardVO);

    }

    @Override //조회수 증가
    public void viewCnt(int boarNum) {
        sqlSession.update("boardMapper.viewCnt",boarNum);
    }
}

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
    public void insert(BoardVO boardVO) {
        sqlSession.insert("boardMapper.insert",boardVO);

    }

    @Override //상세조회
    public BoardVO selectDetail(int boardNum) {

        return sqlSession.selectOne("boardMapper.selectDetail",boardNum);
    }

    @Override // 게시글 삭제
    public void delete(int boardNum) {
        sqlSession.delete("boardMapper.delete",boardNum);
    }

    @Override //게시글 수정
    public void update(int boardNum) {
        sqlSession.update("boardMapper.update",boardNum);
    }


}

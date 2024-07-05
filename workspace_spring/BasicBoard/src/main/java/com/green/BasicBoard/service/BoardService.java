package com.green.BasicBoard.service;

import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;

import java.util.List;

public interface BoardService {

    //목록 조회
    List<BoardVO> getBoardList(SearchVO searchVO);

    //상세 조회
    BoardVO selectDetail(int boardNum);

    //글 작성
    void write(BoardVO boardVO);

    //글 수정
    void update(BoardVO boardVO);

    //글 삭제
    void delete(BoardVO boardVO);

    //검색
    List<BoardVO> search(SearchVO searchVO);

    //조회수 증가
    void updateReadCnt(int boardNum);

}

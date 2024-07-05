package com.green.BasicBoard2.service;

import com.green.BasicBoard2.vo.BoardVO;

import java.util.List;

public interface BoardService {

    //목록 조회
    List<BoardVO> getBoardList();

    //상세페이지 조회
    BoardVO getBoardDetail(int boardNum);

    //게시글 등록
    void write(BoardVO boardVO);

    //게시글 삭제
    void delete(int boardNum);

    //게시글 수정
    void update(BoardVO boardVO);

    //조회수 증가
    void viewCnt(int boarNum);

}

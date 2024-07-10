package com.green.BasicBoard3.service;

import com.green.BasicBoard3.vo.BoardVO;

import java.util.List;

public interface BoardService {

    //게시글 목록
    List<BoardVO> getAllList();

    //게시글 작성
    void insert(BoardVO boardVO);

    //게시글 상세조회
    BoardVO selectDetail(int boardNum);

    //게시글 삭제
    void delete(int boardNum);

    //게시글 수정
    void update(int boardNum);

    //조회수 증가



}

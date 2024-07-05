package com.green.BasicBoard3.service;

import com.green.BasicBoard3.vo.BoardVO;

import java.util.List;

public interface BoardService {

    //게시글 목록
    List<BoardVO> getAllList();

    //게시글 작성
    void insert(int boardNum);

    //게시글 상세조회

    //게시글 삭제

    //게시글 수정

}

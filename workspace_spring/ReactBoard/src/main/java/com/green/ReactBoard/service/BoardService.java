package com.green.ReactBoard.service;

import com.green.ReactBoard.vo.BoardVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getAllList();

    BoardVO getDetail(int boardNum);

    void writeBoard(BoardVO boardVO);

    void deleteBoard(int boardNum);

    void updateBoard(BoardVO boardVO);


}

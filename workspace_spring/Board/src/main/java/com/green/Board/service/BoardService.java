package com.green.Board.service;

import com.green.Board.vo.BoardVO;
import com.green.Board.vo.PageVO;
import com.green.Board.vo.SearchVO;

import java.util.List;

public interface BoardService {

    List<BoardVO> getList(PageVO pageVO);

    BoardVO getDetail(int boardNum);

    void updateBoard(BoardVO boardVO);

    void insertBoard(BoardVO boardVO);

    void delBoard(int boardNum);

    String selectAll(int boardNum);

    int getBoardCnt();



}

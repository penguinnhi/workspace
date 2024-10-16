package com.green.Shop.board.service;

import com.green.Shop.board.vo.BoardVO;

import java.util.List;

public interface BoardService {

    void insertBoard(BoardVO boardVO);

    List<BoardVO> getMyBoard(String memId);

    void updateMyBoard(BoardVO boardVO);

    List<BoardVO> getAdminBoard();

    BoardVO getMyBoardDetail(int boardNum);

    void delMyBoard(int boardNum);
}

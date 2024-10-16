package com.green.Shop.board.controller;

import com.green.Shop.board.service.BoardService;
import com.green.Shop.board.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Resource(name = "boardService")
    private BoardService boardService;

    @PostMapping("/insertBoard")
    public void insertBoard(@RequestBody BoardVO boardVO){
        boardService.insertBoard(boardVO);
    }

    @GetMapping("/selectMyBoard/{memId}")
    public List<BoardVO> selectMyBoard(@PathVariable("memId")String memId){
        return boardService.getMyBoard(memId);
    }

    @PostMapping("/updateMyBoard")
    public void updateMyBoard(@RequestBody BoardVO boardVO){
        boardService.updateMyBoard(boardVO);
    }

    @GetMapping("/selectAdminBoard")
    public List<BoardVO> selectAdminBoard(){
        return boardService.getAdminBoard();
    }

    @GetMapping("/myBoardDetail/{boardNum}")
    public BoardVO getMyBoardDetail(@PathVariable("boardNum") int boardNum){
        return boardService.getMyBoardDetail(boardNum);
    }

    @DeleteMapping("/delMyBoard/{boardNum}")
    public void delMyBoard(@PathVariable("boardNum") int boardNum){
        boardService.delMyBoard(boardNum);
    }

}

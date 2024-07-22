package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Resource(name="boardService")
    public BoardService boardService;

    @GetMapping("/list")
    public List<BoardVO> getBoardList(){
        return boardService.getList();
    }

    @GetMapping("/detail")
    public BoardVO getDetail(@PathVariable("boardNum")int boardNum){
        return boardService.getDetail(boardNum);
    }



}

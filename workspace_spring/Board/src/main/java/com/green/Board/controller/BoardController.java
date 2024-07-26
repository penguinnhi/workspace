package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.vo.BoardVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {

    @Resource(name="boardService")
    public BoardService boardService;

    @GetMapping("/list")
    public List<BoardVO> getBoardList(){
        return boardService.getList();
    }

    @GetMapping("/detail/{boardNum}")
    public BoardVO getDetail(@PathVariable("boardNum")int boardNum){
        return boardService.getDetail(boardNum);
    }

    @PostMapping("/update")
    public void updateBoard(@RequestBody BoardVO boardVO){
        System.out.println(boardVO);
        boardService.updateBoard(boardVO);
    }

    @PostMapping("/insert")
    public void insertBoard(@RequestBody BoardVO boardVO){
        //System.out.println(boardVO);
        //log.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        //log.info(boardVO.toString());
        boardService.insertBoard(boardVO);
    }

    @DeleteMapping("/delBoard/{boardNum}")
    public void delBoard(@PathVariable("boardNum")int boardNum){
        boardService.delBoard(boardNum);
    }






}

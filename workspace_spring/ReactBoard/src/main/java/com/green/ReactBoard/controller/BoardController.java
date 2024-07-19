package com.green.ReactBoard.controller;

import com.green.ReactBoard.service.BoardService;
import com.green.ReactBoard.service.BoardServiceImpl;
import com.green.ReactBoard.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController 어노테이션이 붙은 클래스는 컨트롤러 역할을 함
//단, Controller 어노테이션과 다른 점은
//1. 해당 클래스의 리턴은 html 파일명이 아님
//2. 리턴되는 것은 react로 만든 화면에 보여줄 데이터를 리턴한다.
//3. 메서드의 리턴타입을 잘 지정해야함
@RestController
public class BoardController {
    @Resource(name="boardService")
    private BoardService boardService;


    @GetMapping("/boardList")
    public List<BoardVO> getBoardList(){

        return boardService.getAllList();
    }

    @GetMapping("/getDetail/{boardNum}")
    public BoardVO getDetail(@PathVariable("boardNum")int boardNum){
        return boardService.getDetail(boardNum);
    }

    @PostMapping("/goWrite")
    public void writeBoard(@RequestBody BoardVO boardVO){
        System.out.println(boardVO);
        boardService.writeBoard(boardVO);
    }

    @DeleteMapping("/goDelete/{boardNum}")
    public void deleteBoard(@PathVariable("boardNum")int boardNum){
        boardService.deleteBoard(boardNum);
    }

    @PutMapping("/goUpdate/{boardNum}")
    public void updateBoard(@RequestBody BoardVO boardVO,@PathVariable("boardNum")int boardNum){
        System.out.println(boardNum);
        boardService.updateBoard(boardVO);
        System.out.println(boardVO);
    }




}

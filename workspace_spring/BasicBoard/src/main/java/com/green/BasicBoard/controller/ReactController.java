package com.green.BasicBoard.controller;

import com.green.BasicBoard.service.BoardServiceImpl;
import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReactController {
    @Resource(name="boardService")
    private BoardServiceImpl boardService;

    //
    @RequestMapping("/list") //게시글 목록화면
    public List<BoardVO> boardList(Model model, SearchVO searchVO){


        List<BoardVO> boardList=boardService.getBoardList(searchVO);//목록조회


        return boardList;
    }



}

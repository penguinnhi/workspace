package com.green.Board2.controller;


import com.green.Board2.service.BoardService;
import com.green.Board2.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    @Resource(name="boardService")
    private BoardService boardService;

    @GetMapping("/list")
    public List<BoardVO> getAllList(){
        return boardService.getAllList();
    }



}

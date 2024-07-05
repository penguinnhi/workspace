package com.green.BasicBoard3.controller;

import com.green.BasicBoard3.service.BoardServiceImpl;
import com.green.BasicBoard3.vo.BoardVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    @Resource(name="boardService")
    private BoardServiceImpl boardService;

    //게시글 목록
    @RequestMapping("/")
    public String boardList(Model model){
        List<BoardVO> boardList=boardService.getAllList();
        model.addAttribute("boardList",boardList);

        return "board_list";
    }

    //게시글 작성
    @GetMapping("/writeForm")
    public String writeForm(){

        return "write_form";
    }

    //작성 후 목록페이지로
    @PostMapping("/writeList")
    public String writeList(@RequestParam(name="boardNum")int boardNum,Model model){

        boardService.insert(boardNum);
        model.addAttribute("boardNum",boardNum);

        return "redirect:/";
    }

    //게시글 상세조회 페이지로

    //상세조회 후 목록으로

    //게시글 삭제

    //게시글 수정

    //게시글 수정 후 상세페이지로

}

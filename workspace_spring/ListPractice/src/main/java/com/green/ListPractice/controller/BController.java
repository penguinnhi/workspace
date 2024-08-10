package com.green.ListPractice.controller;

import com.green.ListPractice.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BController {

    List<BoardVO> board_list;

    @GetMapping("/blist") //게시판 목록으로 가는 길
    public String blist(BoardVO boardVO, Model model){
        System.out.println(boardVO);
        model.addAttribute("board",boardVO);

        return"b_list";
    }

    @PostMapping("/bwrite")
    public String bwrite(){
        return "b_write";

    }
    

    @PostMapping("/bdetail")
    public String bdetail(){

        return "b_detail";
    }

}

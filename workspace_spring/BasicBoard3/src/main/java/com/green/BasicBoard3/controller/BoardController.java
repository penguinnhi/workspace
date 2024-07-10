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
    public String writeList(Model model,BoardVO boardVO){

        boardService.insert(boardVO);
        //System.out.println(boardVO);
        //model.addAttribute("board",boardVO);

        return "redirect:/";
    }

    //게시글 상세조회 페이지로
    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam(name="boardNum")int boardNum,Model model){
        BoardVO board=boardService.selectDetail(boardNum);
        model.addAttribute("board",board);

        return "board_detail";
    }

    //게시글 삭제 후 리스트로
    @GetMapping("/deleteBoard")
    public String deleteBoard(int boardNum){
        boardService.delete(boardNum);

        return "redirect:/";
    }

    //게시글 수정
    @PostMapping("/updateForm")
    public String updateForm(@RequestParam(name="boardNum")int boardNum,Model model){

        boardService.update(boardNum);
        //model.addAttribute("boardNum",boardNum);


        return "/update_form";
    }

    //게시글 수정 후 상세페이지로
    @PostMapping("/updateList")
    public String updateList(){
        return "";
    }

}

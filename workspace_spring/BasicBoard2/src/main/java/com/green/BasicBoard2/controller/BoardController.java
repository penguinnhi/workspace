package com.green.BasicBoard2.controller;

import com.green.BasicBoard2.service.BoardService;
import com.green.BasicBoard2.service.BoardServiceImpl;
import com.green.BasicBoard2.vo.BoardVO;
import jakarta.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    @Resource(name="boardService")
    private BoardServiceImpl boardService;

    @RequestMapping("/") //게시글 목록 페이지
    public String boardList(BoardVO boardVO,Model model){

        List<BoardVO> boardList=boardService.getBoardList();//*****************이거때문에
        model.addAttribute("boardList",boardList);

        return "board_list";
    }

    @PostMapping("/writeForm")//게시글 작성 페이지로
    public String writeForm(){

        return "write_form";
    }

    @PostMapping("/writeList")//작성하고 리스트로
    public String writeList(BoardVO boardVO,Model model){

        boardService.write(boardVO);

        return "redirect:/";
    }

    @GetMapping("/boardDetail") // 상세페이지로
    public String boardDetail(@RequestParam(name="boardNum")int boardNum, Model model){

        BoardVO board=boardService.getBoardDetail(boardNum);
        model.addAttribute("board",board);

        boardService.viewCnt(boardNum);

        return "board_detail";
    }

    @GetMapping("/boardDelete")//삭제하고 목록페이지로
    public String boardDelete(@RequestParam(name = "boardNum")int boardNum){

        boardService.delete(boardNum);

        return "redirect:/";
    }

    @GetMapping("/updateForm") //수정페이지로
    public String updateBoard(@RequestParam(name="boardNum")int boardNum, Model model,BoardVO boardVO){

        model.addAttribute(boardVO);//이거안했음 왜하는지 모르겟음 - 원래정보를 보내는 거라는데
        BoardVO board=boardService.getBoardDetail(boardNum);
        model.addAttribute("board",board);

        return "update_form";
    }

    @PostMapping("/updateDetail")//수정하고 상세페이지로
    public String updateDetail(@RequestParam(name = "boardNum")int boardNum,BoardVO boardVO){

        boardService.update(boardVO);

        return "redirect:/boardDetail?boardNum="+boardVO.getBoardNum();
    }



}

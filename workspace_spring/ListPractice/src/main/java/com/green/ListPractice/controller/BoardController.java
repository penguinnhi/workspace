package com.green.ListPractice.controller;

import com.green.ListPractice.vo.BoardVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardController {
    //게시글 목록을 저장할 list 생성 . BoardVO를 여러개 저장할 수 있는 통
    List<BoardVO> boardList = new ArrayList<>();


    //게시글 목록 페이지로 이동
    @GetMapping("/list")
    public String boardList(Model model){
        //게시글 목록 데이터를 html로 전달
        model.addAttribute("boardList",boardList);

        return "board_list";
    }

    //글쓰기 페이지로 이동
    @GetMapping("/board_write_form")
    public String boardWriteForm(){
        return "board_write_form";
    }

    //작성한 내용으로 글 등록하러 온 거임
    @PostMapping("/regBoard")
    public String regBoard(BoardVO boardVO,Model model){
        System.out.println(boardVO);

        boardList.add(boardVO);//******************

        model.addAttribute("boardList",boardList);

        //return에는 원래 이동할 html 파일명 작성
        //redirect: -> 컨트롤러로 이동하겠다는 의미 /list를 다시 실행시키겠음
        return "redirect:/list"; // ? ㅎ?ㅎ?ㅎ?ㅎ?ㅎ?ㅎ?ㅎ?ㅎ?******************
    }


    //글 상세조회 페이지로 이동
    @GetMapping("/detail")
    public String detail(BoardVO boardVO, Model model, @RequestParam(name="boardNum")int boardNum ){
        System.out.println(boardVO);

        //내가 클릭한 게시글의 상세 정보를 html에 뿌려주고 싶음.......
        //1 내가 클릭한 게시글을 어떻게 구분하는데
        //  ㄴ 글번호로 구분
        //내가 클릭한 게시글의 글번호를 알아야함 boardNum
        //게시글 목록에서 내가 가지고 온 글번호와 일치하는 게시글을 찾음

        //2 내가 찾은 게시글을 html에 데이터 전달
        // ?


        BoardVO result=null;
        for (BoardVO board:boardList){
            if (board.getBoardNum()==boardNum) {
                result = board; //board가 내가 찾은 글번호랑 같은 게시글
            }
        }

        model.addAttribute("board",result);




     /*   int a=0;
        String b="";
        String c="";
        String d="";
        String e="";
        for (int i=0;i<boardList.size();i++){
            if (boardNum==boardList.get(i).getBoardNum()){
                a=boardList.get(i).getBoardNum();
                b=boardList.get(i).getWriter();
                c=boardList.get(i).getCreateDate();
                d=boardList.get(i).getTitle();
                e=boardList.get(i).getContent();

            }
        }

        model.addAttribute("a",a);
        model.addAttribute("b",b);
        model.addAttribute("c",c);
        model.addAttribute("d",d);
        model.addAttribute("e",e);
*/



        return "board_detail";
    }


    //게시글 삭제 -> 게시글 목록 페이지로 이동
    @GetMapping("/del")
    public String delete(BoardVO boardVO,Model model,@RequestParam(name="boardNum")int boardNum){

        int idx=0; //삭제할 게시글의 idx번호
        for (int i=0;i<boardList.size();i++){
            if (boardList.get(i).getBoardNum()==boardNum) {
                //board가 내가 찾은 글번호랑 같은 게시글
                idx=i;

            }
        }

        boardList.remove(idx);


        return "redirect:/list";

    }





}

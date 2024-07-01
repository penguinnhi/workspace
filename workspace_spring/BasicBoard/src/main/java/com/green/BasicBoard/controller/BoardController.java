package com.green.BasicBoard.controller;

import com.green.BasicBoard.service.BoardServiceImpl;
import com.green.BasicBoard.vo.BoardVO;
import com.green.BasicBoard.vo.SearchVO;
import jakarta.annotation.Resource;
import org.springframework.boot.Banner;
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



    //
    @RequestMapping("/") //게시글 목록화면
    public String boardList(Model model, SearchVO searchVO){

        System.out.println(searchVO);//searchVO 데이터 검사

        List<BoardVO> boardList=boardService.getBoardList(searchVO);//목록조회

        model.addAttribute("boardList",boardList);




        return "board_list";
    }

    /*@PostMapping("/search") //검색
    public String select(@RequestParam(name="search")String search,@RequestParam(name="searchBox")String searchBox,Model model,BoardVO boardVO){
        //서치를 받았어
        //옵션 타이틀 . 이퀄 서치박스 ?? => 타이틀 리스트?
        if (search.equals("title")){
            if (searchBox.equals(boardVO.getTitle())) {
                List<BoardVO> boardList = boardService.search(boardVO);
                model.addAttribute("boardList", boardList);
            }
        }
        else if (search.equals("writer")){
            if (searchBox.equals(boardVO.getWriter())){
                List<BoardVO> boardList = boardService.search(boardVO);
                model.addAttribute("boardList", boardList);
            }
        }

        return "search_list";
    }
*/
    @PostMapping("/writeForm")
    public String writeForm(){ //글 작성화면

        return "write_form";
    }

    @PostMapping("/writeList")
    public String writeList(Model model,BoardVO boardVO){ // 작성하고 리스트로
        BoardVO board=new BoardVO();
        board.setTitle(boardVO.getTitle());
        board.setWriter(boardVO.getWriter());
        board.setContent(boardVO.getContent());
        //입력을 하고
        boardService.write(board);
        //입력한거 넣고 .. 이게 등록 아니야? title이 null이래 왜?
        //입력한걸 get해서 set하겠다는거 아님?

        model.addAttribute(boardVO);
        //그걸 보내겠다고
        //
        return "redirect:/";
    }

    @GetMapping("/boardDetail")
    public String boardDetail(@RequestParam(name="boardNum")int boardNum,Model model){ // 상세조회화면
        BoardVO board=boardService.selectDetail(boardNum);
        model.addAttribute("board",board);

        return "board_detail";
    }

    @GetMapping("/updateForm")
    public String updateForm(Model model,BoardVO boardVO,@RequestParam(name="boardNum")int boardNum){ // 게시글 수정화면

        model.addAttribute(boardVO);//원래정보
        BoardVO board=boardService.selectDetail(boardNum); //한명 픽해
        model.addAttribute("board",board); // 보내

        return "update_form";
    }

    @PostMapping("/updateList")
    public String updateList(BoardVO boardVO){//수정하고 상세페이지로

        boardService.update(boardVO);

        return "redirect:/boardDetail?boardNum="+boardVO.getBoardNum();
    }

    @GetMapping("/deleteList")
    public String deleteList(BoardVO boardVO){ //삭제하고 목록
        boardService.delete(boardVO);

        return "redirect:/";
    }


}

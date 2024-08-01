package com.green.Board.controller;

import com.green.Board.service.BoardService;
import com.green.Board.vo.BoardVO;
import com.green.Board.vo.PageVO;
import com.green.Board.vo.SearchVO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/board")
public class BoardController {

    @Resource(name="boardService")
    public BoardService boardService;

    // 목록불러오기, 검색하기
    @PostMapping("/list")
    public Map<String,Object> getBoardList(@RequestBody(required = false) SearchVO searchVO){
        //@RequestBody(required = false) SearchVO searchVO
        // System.out.println("!!!!!!!!!!!!!!!"+searchVO);
        System.out.println("........................"+searchVO.getPageNo());
        //전체 게시글수
        boardService.getBoardCnt();

        //페이지 정보를 담을 수 있는 PageVO객체 생성
        PageVO pageInfo=new PageVO(boardService.getBoardCnt());

        if(searchVO.getPageNo()!=0){
            pageInfo.setNowPage(searchVO.getPageNo());
        }


        pageInfo.setPageInfo();


        System.out.println(pageInfo);


        List<BoardVO> boardList= boardService.getList(pageInfo);

        //리액트로 가져갈 모든 데이터를 담을 변수
        Map<String,Object> mapData=new HashMap<>();
        //페이징 정보가 담긴 데이터를
        mapData.put("pageInfo",pageInfo);
        mapData.put("boardList",boardList);

        return mapData;

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

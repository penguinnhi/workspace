package com.green.ReactBoard.controller;

import com.green.ReactBoard.service.AxiosService;
import com.green.ReactBoard.vo.BoardVO;
import com.green.ReactBoard.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AxiosController {
    @Resource(name="axiosService")
    private AxiosService axiosService;


    //1번 버튼 클릭 시 호출되는 메서드
    @GetMapping("/getList")
    public List<BoardVO> getSelect(){

        return axiosService.getSelect();
    }

    @GetMapping("/detail/{boardNum}")
    public void detail(@PathVariable("boardNum")int boardNum ){
        System.out.println(boardNum);
    }

    @PostMapping("/insertBoard")
    public void insertBoard(@RequestBody MemberVO memberVO){
        System.out.println(memberVO);
        System.out.println("🤮");
        //axiosService.insert1();
    }

    @PutMapping("/updateBoard")
    public void updateBoard(@RequestBody BoardVO boardVO){
        System.out.println(boardVO);

    }


}

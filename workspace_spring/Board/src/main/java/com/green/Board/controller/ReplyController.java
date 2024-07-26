package com.green.Board.controller;

import com.green.Board.service.ReplyService;
import com.green.Board.vo.ReplyVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Relation;
import java.util.List;

@RestController
@RequestMapping("/reply")
public class ReplyController {
    @Resource(name="replyService")
    private ReplyService replyService;

    //댓글목록
    @GetMapping("/list/{boardNum}")
    public List<ReplyVO> getReplyList(@PathVariable("boardNum")int boardNum){
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+boardNum);
        return replyService.getReplyList(boardNum);
    }

    @PostMapping("/insert")
    public void insertReply(@RequestBody ReplyVO replyVO){
        replyService.insertReply(replyVO);
    }

    @DeleteMapping("/delete/{replyNum}")
    public void delReply(@PathVariable("replyNum")int replyNum){
        replyService.delReply(replyNum);
    }


}

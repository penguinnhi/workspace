package com.green.Board.service;

import com.green.Board.vo.ReplyVO;

import java.util.List;

public interface ReplyService {

    List<ReplyVO> getReplyList(int boardNum);

    void insertReply(ReplyVO replyVO);

    void delReply(int replyNum);

    void delReplyBoardNum(int boardNum);

//    void del(int boardNum);

    void updateReply(ReplyVO replyVO);

}

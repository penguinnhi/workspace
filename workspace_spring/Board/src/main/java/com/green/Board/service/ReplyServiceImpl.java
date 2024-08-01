package com.green.Board.service;

import com.green.Board.vo.ReplyVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public List<ReplyVO> getReplyList(int boardNum) {
        return sqlSession.selectList("replyMapper.selectReply",boardNum);
    }

    @Override
    public void insertReply(ReplyVO replyVO) {
        sqlSession.insert("replyMapper.insertReply",replyVO);
    }

    @Override
    public void delReply(int replyNum) {
        sqlSession.delete("replyMapper.delReply",replyNum);
    }

    @Override
    public void delReplyBoardNum(int boardNum) {
        sqlSession.delete("replyMapper.delBoardNum",boardNum);
    }

    @Override
    public void updateReply(ReplyVO replyVO) {
        sqlSession.update("replyMapper.updateReply",replyVO);
    }

    //댓글+게시글삭제
//    @Override
//    public void del(int boardNum) {
//        sqlSession.delete("replyMapper.delBoardNum",boardNum);
//        sqlSession.delete("boardMapper.delBoard",boardNum);
//    }


}

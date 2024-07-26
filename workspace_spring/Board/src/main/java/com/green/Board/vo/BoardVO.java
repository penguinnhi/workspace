package com.green.Board.vo;

import lombok.Data;

import java.util.List;

@Data
public class BoardVO {
    private int boardNum;
    private String title;
    private String content;
    private String memId;
    private String CreateDate;
//    private MemberVO memberVO;
    // boardVO 하나는 memberVO 하나를 가질 수 있다는 뜻
    // 쿼리 작성 시 association 1:1
//    private List<ReplyVO> replyList;
    // boardVO 하나는 replyVO 여러개를 가질 수 있다는 뜻
}

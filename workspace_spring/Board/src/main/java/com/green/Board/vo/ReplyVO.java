package com.green.Board.vo;

import lombok.Data;

@Data
public class ReplyVO {
    private int replyNum;
    private int boardNum;
    private String replyContent;
    private String memId;
    private String replyDate;
}

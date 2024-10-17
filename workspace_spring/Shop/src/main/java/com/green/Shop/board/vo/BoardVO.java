package com.green.Shop.board.vo;

import lombok.Data;

@Data
public class BoardVO {
    private int boardNum;
    private int cateNum;
    private String memId;
    private String boardTitle;
    private String boardContent;
    private String createDate;
}

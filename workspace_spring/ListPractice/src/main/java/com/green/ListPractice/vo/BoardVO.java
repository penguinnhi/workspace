package com.green.ListPractice.vo;


import lombok.Data;


//VO : Value Object
//DTO : (=VO) Data Transfer Object
@Data
public class BoardVO {
    private int boardNum;
    private String title;
    private String writer;
    private String createDate;
    private String content;

    //lombok을 쓰면  getter setter 자동으로 만들어줌 ㄷㄷ



}

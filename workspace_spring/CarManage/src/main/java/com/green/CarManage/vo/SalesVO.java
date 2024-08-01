package com.green.CarManage.vo;

import lombok.Data;

@Data
public class SalesVO {
    private int sellNum;
    private String sellerName;
    private String sellerTel;
    private String color;
    private String sellDate;
    private int modelNum;
    private CarVO carVO;
}

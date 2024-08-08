package com.green.Shop.item.vo;

import lombok.Data;

import java.util.List;

@Data
public class ShopItemVO {
    private int itemCode;
    private String itemName;
    private int itemPrice;
    private String itemIntro;
    private int itemStock;
    private String itemStatus;
    private int cateCode;
    private CategoryVO categoryVO;
    private List<ImgVO> imgList;
}

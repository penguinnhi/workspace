package com.green.Shop.cart.vo;

import com.green.Shop.item.vo.ShopItemVO;
import lombok.Data;

@Data
public class CartVO {
    private int cartCode;
    private int itemCode;
    private int cartCnt;
    private String memId;
    private String cartDate;
    private ShopItemVO itemVO;
}

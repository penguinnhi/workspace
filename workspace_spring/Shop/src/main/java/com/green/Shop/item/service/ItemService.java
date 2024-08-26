package com.green.Shop.item.service;


import com.green.Shop.cart.vo.CartVO;
import com.green.Shop.item.vo.ShopItemVO;

import java.util.List;

public interface ItemService {

    List<ShopItemVO> getItemList();

    List<ShopItemVO> getCateList(int cateCode);

    ShopItemVO getDetail(int itemCode);


}
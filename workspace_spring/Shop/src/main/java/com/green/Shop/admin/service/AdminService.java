package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ShopItemVO;

import java.util.List;

public interface AdminService {

    void insertItem(ShopItemVO itemVO);

    List<CategoryVO> getCate();

    void insertImgs(ShopItemVO itemVO);

    //다음에 들어갈 item_code 조회
    int getNextItemCode();

}

package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ShopItemVO;

import java.util.List;

public interface AdminService {

    void insertItem(ShopItemVO itemVO);

    List<CategoryVO> getCate();

}

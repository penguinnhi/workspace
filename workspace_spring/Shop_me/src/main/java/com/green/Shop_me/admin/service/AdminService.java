package com.green.Shop_me.admin.service;

import com.green.Shop_me.item.vo.CategoryVO;
import com.green.Shop_me.item.vo.ItemVO;

import java.util.List;

public interface AdminService {

    List<CategoryVO> getCateList();

    void insertItem(ItemVO itemVO);

}

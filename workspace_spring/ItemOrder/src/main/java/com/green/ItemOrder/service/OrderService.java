package com.green.ItemOrder.service;

import com.green.ItemOrder.vo.ItemVO;

import java.util.List;

public interface OrderService {

    List<ItemVO> getList();

    ItemVO getDetail(int itemNum);

    void insertItem(ItemVO itemVO);

    void updateItem(ItemVO itemVO);
}

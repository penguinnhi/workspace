package com.green.CarManage.service;

import com.green.CarManage.vo.SalesVO;

import java.util.List;

public interface SalesService {

    void insertSeller(SalesVO salesVO);

    List<SalesVO> salesList();
}

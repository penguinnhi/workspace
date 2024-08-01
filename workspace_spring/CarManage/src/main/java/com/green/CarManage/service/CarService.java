package com.green.CarManage.service;

import com.green.CarManage.vo.CarVO;

import java.util.List;

public interface CarService {

    void insertCar(CarVO carVO);

    List<CarVO> getCarList();
}

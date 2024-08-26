package com.green.CarManage.controller;

import com.green.CarManage.service.CarService;
import com.green.CarManage.vo.CarVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Resource(name="carService")
    private CarService carService;

    @PostMapping("/insert")
    public void insertCar(@RequestBody CarVO carVO){
        carService.insertCar(carVO);
    }

    @GetMapping("/list")
    public List<CarVO> getCarList(){
        return carService.getCarList();
    }


}

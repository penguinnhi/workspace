package com.green.CarManage.controller;

import com.green.CarManage.service.SalesService;
import com.green.CarManage.vo.SalesVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Resource(name="salesService")
    private SalesService salesService;

    @PostMapping("/insert")
    public void insertSeller(@RequestBody SalesVO salesVO){
        salesService.insertSeller(salesVO);
    }

    @GetMapping("/select")
    public List<SalesVO> sellerList(){
        return salesService.salesList();
    }


}

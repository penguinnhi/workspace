package com.green.ItemOrder.controller;

import com.green.ItemOrder.service.OrderService;
import com.green.ItemOrder.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Resource(name="orderService")
    private OrderService orderService;

    @GetMapping("/getItemInfo")
    public List<ItemVO> getItemList(){
        return orderService.getList();
    }

    @GetMapping("/getItemDetail/{itemNum}")
    public ItemVO getItemDetail(@PathVariable("itemNum") int itemNum) {
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!" + itemNum);
        return orderService.getDetail(itemNum);
    }

    @PostMapping("/insertItem")
    public void insertItem(@RequestBody ItemVO itemVO) {
        orderService.insertItem(itemVO);
    }

    @PutMapping("/updateItem/{itemNum}")
    public void updateItem(@RequestBody ItemVO itemVO){
        System.out.println("!!!!!!!!!!!!!!!"+itemVO);
        orderService.updateItem(itemVO);
    }


}

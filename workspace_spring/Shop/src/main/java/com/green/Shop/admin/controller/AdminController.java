package com.green.Shop.admin.controller;

import com.green.Shop.admin.service.AdminService;
import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ShopItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource(name="adminService")
    private AdminService adminService;

    @PutMapping("/insert")
    public void insertItem(@RequestBody ShopItemVO itemVO){
        adminService.insertItem(itemVO);
    }

    @GetMapping("/list")
    public List<CategoryVO> getList(){
        return adminService.getCate();
    }
}

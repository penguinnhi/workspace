package com.green.Shop_me.admin.controller;


import com.green.Shop_me.admin.service.AdminService;
import com.green.Shop_me.item.vo.CategoryVO;
import com.green.Shop_me.item.vo.ItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource(name="adminService")
    private AdminService adminService;


    @GetMapping("/list")
    public List<CategoryVO> getCateList(){
        return adminService.getCateList();
    }

    @PutMapping("/insert")
    public void insertItem(@RequestBody ItemVO itemVO){
        adminService.insertItem(itemVO);
    }

}

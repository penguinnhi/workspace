package com.green.Shop.item.controller;

import com.green.Shop.item.service.ItemService;
import com.green.Shop.item.service.ItemServiceImpl;
import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ShopItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Resource(name="itemService")
    private ItemService itemService;

    @GetMapping("/list")
    public List<ShopItemVO> getAllList(){
        return itemService.getItemList();
    }

    @GetMapping("/detail/{itemCode}")
    public ShopItemVO getDetail(@PathVariable("itemCode")int itemCode){
        System.out.println(itemCode);
        return itemService.getDetail(itemCode);
    }

    @GetMapping("/cateList/{cateCode}")
    public List<ShopItemVO> getCateList(@PathVariable("cateCode")int cateCode){
        return itemService.getCateList(cateCode);
    }

}

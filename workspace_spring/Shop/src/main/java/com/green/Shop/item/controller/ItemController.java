package com.green.Shop.item.controller;

import com.green.Shop.item.service.ItemService;
import com.green.Shop.cart.vo.CartVO;
import com.green.Shop.item.vo.ShopItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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
        //System.out.println(itemCode);
        return itemService.getDetail(itemCode);
    }

    @GetMapping("/cateList/{cateCode}")
    public List<ShopItemVO> getCateList(@PathVariable("cateCode")int cateCode){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!"+cateCode);
        return itemService.getCateList(cateCode);
    }


}

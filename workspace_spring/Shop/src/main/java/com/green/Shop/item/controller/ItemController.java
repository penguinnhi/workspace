package com.green.Shop.item.controller;

import com.green.Shop.item.service.ItemService;
import com.green.Shop.cart.vo.CartVO;
import com.green.Shop.item.vo.SearchVO;
import com.green.Shop.item.vo.ShopItemVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Resource(name="itemService")
    private ItemService itemService;

    @PostMapping("/list")
    public List<ShopItemVO> getAllList(@RequestBody(required = false)SearchVO searchVO){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@"+searchVO);
        return itemService.getItemList(searchVO);
    }

    @GetMapping("/detail/{itemCode}")
    public ShopItemVO getDetail(@PathVariable("itemCode")int itemCode){
        //System.out.println(itemCode);
        return itemService.getDetail(itemCode);
    }

    @GetMapping("/cateList/{cateCode}")
    public List<ShopItemVO> getCateList(@PathVariable("cateCode")int cateCode){
        return itemService.getCateList(cateCode);
    }

    @DeleteMapping("/delItem/{itemCode}")
    public void delItem(@PathVariable("itemCode")int itemCode){
        itemService.delItem(itemCode);
    }


}

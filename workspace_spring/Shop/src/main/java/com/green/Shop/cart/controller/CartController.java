package com.green.Shop.cart.controller;

import com.green.Shop.cart.service.CartService;
import com.green.Shop.cart.vo.CartVO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Resource(name="cartService")
    private CartService cartService;

    @PutMapping("/putInCart")
    public void putInCart(@RequestBody CartVO cartVO){
        System.out.println("!!!!!!!!!!!!!"+cartVO);
        cartService.putInCart(cartVO);
    }

    @GetMapping("/cartList/{memId}")
    public List<CartVO> selectCart(@PathVariable("memId")String memId){
        //System.out.println("!!!!!!!!!!!!!!!!!!!"+memId);
        return cartService.selectCart(memId);
    }

    @DeleteMapping("/del/{cartCode}")
    public void deleteInCart(@PathVariable("cartCode")int cartCode){
        cartService.deleteInCart(cartCode);
    }


}

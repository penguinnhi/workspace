package com.green.Shop.cart.service;

import com.green.Shop.cart.vo.CartVO;

import java.util.List;

public interface CartService {

    void putInCart(CartVO cartVO);

    List<CartVO> selectCart(String memId);

    void deleteInCart(int cartCode);

}

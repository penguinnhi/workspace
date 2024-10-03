package com.green.Shop.cart.service;

import com.green.Shop.cart.vo.CartVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void putInCart(CartVO cartVO) {
        //내 장바구니에 상품 존재 여부 확인
        CartVO checkCart = sqlSession.selectOne("cartMapper.checkInCart",cartVO);

        //없으면 insert, 있으면 update
        if(checkCart==null){
            //등록
            sqlSession.insert("cartMapper.putInCart",cartVO);
        }
        else {
            sqlSession.update("cartMapper.updateCartCntWhenReg",cartVO);
        }
    }

    @Override
    public List<CartVO> selectCart(String memId) {
        return sqlSession.selectList("cartMapper.selectCart",memId);
    }

    @Override
    public void deleteInCart(int cartCode) {
        sqlSession.delete("cartMapper.deleteInCart",cartCode);
    }
}

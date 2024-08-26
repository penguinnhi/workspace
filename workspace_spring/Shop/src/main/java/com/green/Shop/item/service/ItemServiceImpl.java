package com.green.Shop.item.service;

import com.green.Shop.cart.vo.CartVO;
import com.green.Shop.item.vo.ShopItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<ShopItemVO> getItemList() {
        return sqlSession.selectList("itemMapper.getItemList");
    }

    @Override
    public List<ShopItemVO> getCateList(int cateCode) {
        return sqlSession.selectList("itemMapper.getCateList",cateCode);
    }

    @Override
    public ShopItemVO getDetail(int itemCode) {
        return sqlSession.selectOne("itemMapper.itemDetail",itemCode);
    }



}
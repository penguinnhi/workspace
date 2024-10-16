package com.green.Shop.item.service;

import com.green.Shop.cart.vo.CartVO;
import com.green.Shop.item.vo.SearchVO;
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
    public List<ShopItemVO> getItemList(SearchVO searchVO) {
        return sqlSession.selectList("itemMapper.getItemList",searchVO);
    }

    @Override
    public List<ShopItemVO> getCateList(int cateCode) {
        return sqlSession.selectList("itemMapper.getCateList",cateCode);
    }

    @Override
    public ShopItemVO getDetail(int itemCode) {
        return sqlSession.selectOne("itemMapper.itemDetail",itemCode);
    }

    @Override
    public void delItem(int itemCode) {
        sqlSession.delete("itemMapper.delItem",itemCode);
    }


}

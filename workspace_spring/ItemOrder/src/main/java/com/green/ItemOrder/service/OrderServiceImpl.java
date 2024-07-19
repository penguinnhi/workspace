package com.green.ItemOrder.service;

import com.green.ItemOrder.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<ItemVO> getList() {
        return sqlSession.selectList("itemOrder.getList");
    }

    @Override
    public ItemVO getDetail(int itemNum) {
        return sqlSession.selectOne("itemOrder.getDetail",itemNum);
    }

    @Override
    public void insertItem(ItemVO itemVO) {
        sqlSession.insert("itemOrder.insertItem",itemVO);
    }

    @Override
    public void updateItem(ItemVO itemVO) {
        sqlSession.update("itemOrder.updateItem",itemVO);
    }
}

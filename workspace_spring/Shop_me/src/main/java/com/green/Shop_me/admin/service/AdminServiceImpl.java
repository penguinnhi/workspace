package com.green.Shop_me.admin.service;

import com.green.Shop_me.item.vo.CategoryVO;
import com.green.Shop_me.item.vo.ItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public List<CategoryVO> getCateList() {
        return sqlSession.selectList("adminMapper.getCateList");
    }

    @Override
    public void insertItem(ItemVO itemVO) {
        sqlSession.insert("adminMapper.insertItem");
    }
}

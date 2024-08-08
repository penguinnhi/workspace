package com.green.Shop.admin.service;

import com.green.Shop.item.vo.CategoryVO;
import com.green.Shop.item.vo.ShopItemVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public void insertItem(ShopItemVO itemVO) {
        sqlSession.insert("adminMapper.insertItem",itemVO);
    }

    @Override
    public List<CategoryVO> getCate() {
        return sqlSession.selectList("adminMapper.selectAllCate");
    }

    @Override
    public void insertImgs(ShopItemVO itemVO) {
        sqlSession.insert("adminMapper.insertImgs",itemVO);
    }

    //다음에 들어갈 item_code 조회
    @Override
    public int getNextItemCode() {
        return sqlSession.selectOne("adminMapper.getNextItemCode");
    }


}

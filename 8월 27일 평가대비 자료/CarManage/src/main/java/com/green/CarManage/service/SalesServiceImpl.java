package com.green.CarManage.service;

import com.green.CarManage.vo.SalesVO;
import jakarta.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("salesService")
public class SalesServiceImpl implements SalesService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void insertSeller(SalesVO salesVO) {
        sqlSession.insert("salesMapper.insertSeller",salesVO);
    }

    @Override
    public List<SalesVO> salesList() {
        return sqlSession.selectList("salesMapper.select");
    }


}

package com.green.Board2.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl {
    @Autowired
    private SqlSessionTemplate sqlSession;
}

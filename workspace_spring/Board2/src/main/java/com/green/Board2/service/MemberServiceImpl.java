package com.green.Board2.service;

import com.green.Board2.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void joinMem(MemberVO memberVO) {
        sqlSession.insert("memberMapper.joinMem",memberVO);
    }

    @Override
    public boolean isDup(String memId) {

        String id=sqlSession.selectOne("memberMapper.isDuplicated",memId);


        return id!=null;
    }
}

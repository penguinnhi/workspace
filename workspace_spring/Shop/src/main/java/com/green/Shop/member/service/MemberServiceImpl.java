package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void goJoin(MemberVO memberVO) {
        sqlSession.insert("memberMapper.joinMem",memberVO);
    }

    @Override
    public boolean isDup(String memId) {

        String id=sqlSession.selectOne("memberMapper.isDuplicated",memId);

        return id!=null;
    }

    @Override
    public MemberVO goLogin(MemberVO memberVO) {
        return sqlSession.selectOne("memberMapper.goLogin",memberVO);
    }
}

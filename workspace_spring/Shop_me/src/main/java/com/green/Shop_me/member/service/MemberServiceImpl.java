package com.green.Shop_me.member.service;

import com.green.Shop_me.member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;


    @Override
    public void insertMem(MemberVO memberVO) {
        sqlSession.insert("memberMapper.insertMember",memberVO);
    }

    @Override
    public boolean isDup(String memId) {
        // id가 null이면 회원가입 가능
        // id가 조회가 된다면 회원가입 안됨
        String id=sqlSession.selectOne("memberMapper.isDuplicated",memId);
        return id!=null;
    }

    @Override
    public MemberVO goLogin(MemberVO memberVO) {
        return sqlSession.selectOne("memberMapper.login",memberVO);
    }


}

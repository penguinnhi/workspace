package com.green.Board.service;

import com.green.Board.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
    @Autowired
    private SqlSessionTemplate sqlSession;

    @Override
    public void legMember(MemberVO memberVO) {
        sqlSession.insert("memberMapper.regMem",memberVO);
    }

    @Override
    public MemberVO logInMember(MemberVO memberVO) {
        return sqlSession.selectOne("memberMapper.logIn",memberVO);
    }


}

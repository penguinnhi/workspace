package com.green.Board.service;

import com.green.Board.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<MemberVO> getMemList() {
        return sqlSession.selectList("memberMapper.memberList");
    }

    //중복 true, 중복아니면 false
    @Override
    public boolean isDup(String memId) {
        // id가 null이면 회원가입 가능
        // id가 조회가 된다면 회원가입 안됨
        String id= sqlSession.selectOne("memberMapper.isDuplicated",memId);

        return id!=null;

    }



}

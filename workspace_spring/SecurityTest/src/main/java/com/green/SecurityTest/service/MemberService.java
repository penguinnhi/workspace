package com.green.SecurityTest.service;

import com.green.SecurityTest.vo.MemberVO;

public interface MemberService {

    void test1();

    // 회원 가입
    void join(MemberVO memberVO);

    // 로그인하려는 회원의 정보 조회
    MemberVO getMemberForLogin(String memId);

}

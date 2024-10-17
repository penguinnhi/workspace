package com.green.Shop.member.service;

import com.green.Shop.member.vo.MemberVO;

public interface MemberService {

    void goJoin(MemberVO memberVO);

    boolean isDup(String memId);

    MemberVO goLogin(MemberVO memberVO);

    MemberVO selectMem(String memId);
}

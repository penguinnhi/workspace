package com.green.Shop_me.member.service;

import com.green.Shop_me.member.vo.MemberVO;

public interface MemberService {

    void insertMem(MemberVO memberVO);

    boolean isDup(String memId);
}

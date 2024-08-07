package com.green.Board2.service;

import com.green.Board2.vo.MemberVO;

public interface MemberService {

    void joinMem(MemberVO memberVO);

    boolean isDup(String memId);
}

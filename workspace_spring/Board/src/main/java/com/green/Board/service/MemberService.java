package com.green.Board.service;

import com.green.Board.vo.MemberVO;

public interface MemberService {

    void legMember(MemberVO memberVO);

    MemberVO logInMember(MemberVO memberVO);
}

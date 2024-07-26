package com.green.Board.service;

import com.green.Board.vo.MemberVO;

import java.util.List;

public interface MemberService {

    void legMember(MemberVO memberVO);

    MemberVO logInMember(MemberVO memberVO);

    List<MemberVO> getMemList();

    boolean isDup(String memId);


}

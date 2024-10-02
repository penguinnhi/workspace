package com.green.SecurityTest.service;

import com.green.SecurityTest.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
@RequiredArgsConstructor // Lombok, final이 붙어있는 변수를 매개변수로 갖는 생성자
//@AllArgsConstructor // 모든 매개변수를 갖는 생성자 생성
//@NoArgsConstructor // 매개변수를 가지지 않느 생성자 생성
public class MemberServiceImpl implements MemberService {
    // 생성자 주입
    // 기존과 달라진점
    // 1. 선언한 객체 위에 어노테이션 생략
    // 2. 선언한 변수에 final 키워드가 붙는다
    // 3. 클래스에 @RequiredArgsConstructor 어노테이션이 붙는다.
//    @Autowired
    private final SqlSessionTemplate sqlSession; // final이 붙으면 초기값이 필요함

    // 생성자 주입
//    @Autowired
//    public MemberServiceImpl (SqlSessionTemplate sqlSession){
//        this.sqlSession=sqlSession;
//    }


    @Override
    public void test1() {
        System.out.println(111);
    }

    @Override
    public void join(MemberVO memberVO) {
        sqlSession.insert("memberMapper.join",memberVO);
    }


}

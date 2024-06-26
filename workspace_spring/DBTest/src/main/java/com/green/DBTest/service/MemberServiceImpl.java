package com.green.DBTest.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//implements
//TEST_MEMBER 테이블에 데이터를 조작하는 DB 작업을 하는 클래스

//MemberServiceImpl memberServiceImpl = new MemberServiceImpl();
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    //SqlSessionTemplate 객체 : 쿼리 실행을 위한 메서드를 가지고 있는 객체
    //쿼리 실행을 위한 메서드
    //데이터 삽입 (INSERT) : sqlSession(객체명).insert("쿼리가 있는 mapper파일의 namespace.쿼리 id, [실행할 쿼리의 빈값을 채울 데이터]");
    //데이터 삭제 (DELETE) : sqlSession(객체명).delete("쿼리가 있는 mapper파일의 namespace.쿼리 id, [실행할 쿼리의 빈값을 채울 데이터]");
    //데이터 수정 (UPDATE) : sqlSession(객체명).update("쿼리가 있는 mapper파일의 namespace.쿼리 id, [실행할 쿼리의 빈값을 채울 데이터]");
    //데이터 조회 (SELECT) : sqlSession(객체명).selectOne("쿼리가 있는 mapper파일의 namespace.쿼리 id, [실행할 쿼리의 빈값을 채울 데이터]");
    //                                      .selectList("쿼리가 있는 mapper파일의 namespace.쿼리 id, [실행할 쿼리의 빈값을 채울 데이터]");
    @Autowired
    private SqlSessionTemplate sqlSession; //Mybatis 안에 있는 클래스

    //TEST_MEMBER 테이블에 데이터 1개 삽입
    @Override
    public void insertMember() {
        sqlSession.insert("memberMapper.insert1");

    }

    @Override
    public void insertMember2() {
        // (쿼리가 있는 mapper파일의 namespace.쿼리 id);
        sqlSession.insert("memberMapper.insert2", 20);
    }




}

package com.green.DB_Member.service;


import com.green.DB_Member.vo.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbService")
public class DBServiceImpl implements DBService {
    @Autowired
    private SqlSessionTemplate sqlSession; //쿼리가 담긴 객체,, ?!


    //실행할 쿼리가 select면 selectOne(),selectList() 메서드 중 하나를 사용
    //조회 결과 데이터가 0행 혹은 1행이면 selectOne() 사용
    //조회 결과 데이터 행 개수가 고정되지 않으면 selectList() 사용
    //인터페이스에서는 작성한 쿼리를 실행할 메서드
    @Override
    public String select1() {
        //namespace.쿼리id
        String name = sqlSession.selectOne("dbMapper.select1");
        //sqlSession.selectList();
        return name;
    }

    //전달된 회원번호를 지닌 회원의 나이를 조회
    @Override
    public int select2(int memNum) {
        int age=sqlSession.selectOne("dbMapper.select2",memNum);
        return age;
    }


    //전달받은 나이 이상인 회원의 이름을 조회
    @Override
    public List<String> select3(int memAge) {
        List<String> nameList=sqlSession.selectList("dbMapper.select3",memAge);

        return nameList;
    }
    //행이 여러개면 selectList

    //전달받은 회원번호를 지닌 회원의 회원번호,이름,나이,주소를 조회
    @Override
    public MemberVO select4(int memNum) {
        MemberVO num=sqlSession.selectOne("dbMapper.select4",memNum);
        return num;
    }

    //모든 회원의 회원번호 이름 나이 주소를 조회
    @Override
    public List<MemberVO> select5() {
        List<MemberVO> member=sqlSession.selectList("dbMapper.select5");
        return member;
    }


    @Override
    public int delete(int memNum) {
        int member=sqlSession.delete("dbMapper.delete",memNum);
        return member;
    }

    @Override
    public void insert(MemberVO memberVO) {
        sqlSession.insert("dbMapper.insert",memberVO);

    }

    @Override
    public int update(MemberVO memberVO) {
        int mm1=sqlSession.update("dbMapper.update",memberVO);
        return mm1;
    }


}

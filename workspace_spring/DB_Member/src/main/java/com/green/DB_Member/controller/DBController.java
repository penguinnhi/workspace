package com.green.DB_Member.controller;

import com.green.DB_Member.service.DBService;
import com.green.DB_Member.service.DBServiceImpl;
import com.green.DB_Member.vo.MemberVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.crypto.dsig.dom.DOMValidateContext;
import java.util.List;

@Controller
public class DBController {
    @Resource(name="dbService")
    private DBServiceImpl dbService;

    //회원번호가 1번인 회원의 이름을 조회,,,.,.,.,.,.,.,.,...
    @GetMapping("/select1")
    public String select1(){
        String name=dbService.select1();
        System.out.println("조회한 이름 : "+name);
        return "db_result";
    }

    //전달된 회원번호를 지닌 회원의 나이를 조회
    @GetMapping("/select2")
    public String select2(){
        int age= dbService.select2(5);
        System.out.println("조회한 나이 : "+age);
        return "db_result";
    }

    //눈 딱 감고 낙 하아ㅏㅏ 하ㅏㅏㅏ 하ㅏㅏㅏ 믿어 날 눈 딱 감고 낙 하ㅏㅏㅏㅏㅏ우~~
    //전달받은 나이 이상의 회원의 이름을 조회
    @GetMapping("/select3")
    public String select3(){
        List<String> nameList=dbService.select3(30);

        for (String a:nameList){
            System.out.println("조회 : "+a);
        }
        return "db_result";
    }

    //전달받은 회원번호를 지닌 회원의 회원번호,이름,나이,주소를 조회
    @GetMapping("/select4")
    public String select4(){
        MemberVO num= dbService.select4(4);
        System.out.println("조회 : "+num);

        return "db_result";
    }

    //모든 회원의 회원번호 이름 나이 주소를 조회
    @GetMapping("/select5")
    public String select5(){
        List<MemberVO> member=dbService.select5();
        for (MemberVO m:member){
            System.out.println("조회 : "+m);
        }
        return "db_result";
    }

    //전달받은 회원 번호를 가진 회원을 삭제
    @GetMapping("/delete")
    public String delete(){
        int member=dbService.delete(1);
        System.out.println("삭제한 행 개수 : "+member);

        return "db_result";
    }

    @GetMapping("/insert")
    public String insert(){
        MemberVO vo=new MemberVO();
        vo.setMemNum(66);
        vo.setMemName("우히");
        vo.setMemAge(66);
        vo.setMemAddr("이히히");
        dbService.insert(vo);
        return "db_result";
    }

    //전달받은 회원번호를 지닌 회원이름,나이,주소를 변경
    @GetMapping("/update")
    public String update(){
        MemberVO vo=new MemberVO();
        vo.setMemNum(3);
        vo.setMemName("애월");
        vo.setMemAge(25);
        vo.setMemAddr("제주");

        int result=dbService.update(vo);
        System.out.println(result);
        return "db_result";
    }



}

package com.green.AxiosTest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


//RestController : 컨트롤러 안의 메서드 리턴이 html 파일명이 아님
@RestController
public class AxiosController {

    @GetMapping("/test1")
    public String test1(){

        return "heeeeeeeeeeeeeeeey";
    }

    @GetMapping("/test2")
    public int test2(){
        return 100;
    }

    @GetMapping("/test3")
    public int[] test3(){
        int[] arr={1,2,3,4,5};
        return arr;
    }

    @GetMapping("/test4")
    public List<ItemVO> test4(){
        List<ItemVO> item=new ArrayList<>();
        //ItemVO 객레를 세 개 리액트로 전달
        ItemVO item1=new ItemVO(1,"hihi",20000,"kiki","book_1.jpg");
        ItemVO item2=new ItemVO(2,"haha",30000,"kaka","book_2.jpg");
        ItemVO item3=new ItemVO(3,"huhu",12000,"kuku","book_3.jpg");

        item.add(item1);
        item.add(item2);
        item.add(item3);

        return item;
    }

}

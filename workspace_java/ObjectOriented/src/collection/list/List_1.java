package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class List_1 {
    public static void main(String[] args) {
        //ArrayList 객체 생성
        //ArrayList<String> list1 = new ArrayList<>();
        //String 데이터를 다수 저장하기 위한 list(통) 생성
        //list

        List<String> list1 = new ArrayList<>();//*********

        //리스트에 데이터 저장하기
        list1.add("dd");//add가 데이터 넣는 메서드
        list1.add("ㅇㅇ");//add가 데이터 넣는 메서드
        list1.add("dkfdl");
        list1.add("woejrf");

        //리스트에 저장된 데이터 읽기 , 순번으로 접근
        String re = list1.get(1);
        System.out.println(re);

        //리스트에 저장된 데이터 삭제
        String re1 = list1.remove(3);//
        System.out.println(re1);

        //리스트에 저장된 데이터 수
        System.out.println(list1.size());

        //리스트에 저장된 모든 데이터 출력

        for (int i=0;i<list1.size();i++){
            System.out.println(list1.get(i));
        }
        //어려워요 헷갈리고



        //정수를 데이터
        /*ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(23);
        list2.add(5555);*/


    }




}

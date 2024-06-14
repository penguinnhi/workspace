package collection.list;

import java.util.ArrayList;
import java.util.List;

public class List_2 {
    public static void main(String[] args) {
        //정수를 다수 저장할 수 있는 리스트 생성
        List<Integer> li=new ArrayList<>();

        li.add(23);
        li.add(75);

        int a = li.get(0);//읽어오기 순번
        System.out.println(a);

        li.remove(1);//삭제하기
        li.size();//리스트에 들어가 있는 데이터 수



    }
}

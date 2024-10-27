package basic;

import java.util.HashMap;
import java.util.Map;

public class BoxTest {

    public static void main(String[] args) {
        // 제네릭 문법이 적용된 클래스는 클래스 구현 시에는 자료형을 지정하지 않았다.
        // 제네릭 문법이 적용된 클래스의 자료형은 객체 생성 시 결정해야함.
        // Box 객체 생성
        Box<String> box1=new Box<>();
        box1.setData("java");
        String data1 = box1.getData();

        Box<Integer> box2=new Box<>();
        box2.setData(123);
        int data2 = box2.getData();

        // Apple 객체를 저장할 수 있는 박스
        Box<Apple> box3 = new Box<>();
        box3.setData(new Apple());
        Apple data3=box3.getData();

        Map<String,Integer> map = new HashMap<>();

        //MemberVO를 저장할 수 있는 box생성
        Box<MemberVO> box4=new Box<>();



    }
}

package basic;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodTest {

    public static void main(String[] args) {
        GenericMethod.aaa(); // 객체 생성 안 하고 바로 메서드 불러오기 가능한

        // 제네릭 메서드의 자료형은 메서드 호출 시 결정
        Box<String> b1 = GenericMethod.makeBox("java");
        Box<Integer> b2 = GenericMethod.makeBox(123);

        Box<String> box1=new Box<>();
        GenericMethod.peekBox(box1);

        GenericMethod.peekBox1(b1);
        GenericMethod.peekBox1(b2);

        List<String> list=new ArrayList<>();
        // Collection<? extends String>
        // = Collection<String>
//        list.addAll();



    }
}

package object;

import java.sql.SQLOutput;

public class String_3 {
    public static void main(String[] args) {
        //String 객체의 특이점
        //String 객체는 Immutable(값이 변하지 않는) 객체
        //불변성(Immutability): string 객체는 생성된 후에 수정될 수 없습니다.
        // string에 대해 어떤 변경을 시도하면, 사실상 새로운 string 객체가 생성되고, 변경된 내용이 반영됩니다.
        // 이전 string은 변경되지 않습니다. 이러한 불변성 때문에, string을 값 형식처럼 느껴지게 하는 속성 중 하나입니다.

        String addr1="울산";
        String addr2=addr1;
        addr1="제주"; //제주로 바뀐 주소값을 가리킴, addr2는 여전히 원래 1의 주소값 울산을 가리킴

        System.out.println(addr1);//제주
        System.out.println(addr2);//울산

        //값이 변하지 않는다
        String a="java";
        a="python";
        System.out.println(a);//python



    }

}

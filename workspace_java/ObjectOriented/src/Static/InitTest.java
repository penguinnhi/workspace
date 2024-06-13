package Static;

import java.security.PublicKey;

public class InitTest {


    public static void main(String[] args) {

        StaticInit i1=new StaticInit();
        //a는 i1안에 포함되는데 static인 num은 i1안에 포함되는게 아니라 걍 지공간이 잇는거임 아 모르겟음;
        //i1 (a=10) -> num = 5 > num++; : num = 6 (static이 생성자 안에서 초기화 될 때 )
        //생성자 실행 전에 num = 5 > 생성자 실행 i1 (a=10) > num++; : num = 6 (static 변수 초기화)

        StaticInit i2=new StaticInit();
        //i2 (a=10) -> 다시 num = 5 > num++; : num = 6 (static이 생성자 안에서 초기화 될 때 )
        //num = 6 > 생성자 실행 i1(a=10) > num++; : num = 7 (static 변수 초기화) 암튼 기본변수랑 다르다

        StaticInit i3=new StaticInit();

        System.out.println();
        //static 변수를 읽고 사용하는 방법
        //객체명.변수명으로 static 변수도 사용 가능함. 추천하지 않는 방법
        System.out.println(i1.num);//i1안에 num이 있는게 아님
        System.out.println(i2.num);

        //static 변수 및 메서드는
        //클래스명.변수명
        //이러한 접근 방법은 객체를 만들지 않아도 사용 가능
        System.out.println(StaticInit.num);//객체 안 만들어도 사용 가능함. 객체가 만들어지기 전에 static 먼저 읽기 때문에

        //

        Math.random();
        //Math. 클래스명.뒤에 바로 올 수 있는 건 static 이라서

        System.out.println();//println이 오버로딩 되어 있기 때문에 암거나 다 쓸 수 있음


    }
}



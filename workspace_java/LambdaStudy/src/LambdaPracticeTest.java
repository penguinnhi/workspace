import java.util.ArrayList;
import java.util.List;

public class LambdaPracticeTest {
    public static void main(String[] args) {
        // 람다를 이용해서 LambdaPractice 인터페이스 안의
        // printName 메서드의 기능을 "홍길동입니다."가 출력될 수 있도록 구현하여 호출하여 확인해보세요.

        // 매개변수가 없으면 매개변수 자리의 소괄호 생략 불가

        LambdaPractice lam=()-> System.out.println("홍길동입니다.");
        lam.printName();

        List<String> nameList=new ArrayList<>();
        nameList.add("고길동");
        nameList.add("이길동");
        nameList.add("유지현");

        nameList.forEach((e)->{
            System.out.println(e);
        });


        // 매개변수의 자료형은 생략, 매개변수명은 원하는대로
        // 매개변수가 하나라면 매개변수 자료의 소괄호 생략 가능
        LambdaPractice1 p1=name->System.out.println(name);
        p1.printName("고길동");


        LambdaPractice2 p2=(name,age)->{
            System.out.println(name);
            System.out.println(age);
        };
        p2.printMyInfo("고길동",43);

        // 리턴타입이 있는 람다식은 중괄호 생략 불가능
        // 중괄호를 생략하려면 return 키워드도 생략해야함
        LambdaPractice3 p3=()-> 23;
        p3.getData();


        LambdaPractice4 p4=(a,b)->a+b;
        p4.getResult(2,3);


        // 계산기

        LambdaPractice5 p5=(a,b)->a-b;
        p5.getResult(10,5);

        LambdaPractice5 p51=(a,b)->a*b;
        p5.getResult(10,5);

        LambdaPractice5 p52=(a,b)->a/b;
        p5.getResult(10,5);


        // --- 1022

        LambdaPractice6<Integer> p6=(a,b)->a+b;
        p6.getResult(10,5);

        LambdaPractice6<String> p61=(a,b)->a+b;
        p61.getResult("a","b"); // = "ab"


        // String 변수 자료형, Integer는 리턴타입
        LambdaPractice7<String,Integer> p7=(a,b)->a.length()+b.length();
        p7.getResult("뿡","123"); // 4 리턴





    }
}

class Aaa implements LambdaPractice6{

    //메서드 오버라이딩
    // : 상속 관계에서 부모 클래스의 메서드를 자식클래스에서 재정의 가능

    @Override
    public Object getResult(Object a, Object b) {
        return null;
    }


}




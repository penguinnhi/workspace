package 상속;


//메서드 오버라이딩 overriding*********
// : 상속 관계에서 부모 클래스의 메서드를 자식클래스에서 재정의 가능
//

public class Cake {
    public void eat(){
        System.out.println("케이크먹음");
    }
}

class CheeseCake extends Cake{

    public void eat(){
        super.eat();//부모클래스의 eat 호출
        System.out.println("아니 주스먹음");
    }
}

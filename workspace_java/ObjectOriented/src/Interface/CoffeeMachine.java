package Interface;

//' 머신 인터페이스에 정의한 메서드를 구현한 커피머신 클래스를 생성하겠다 '
//implements : 구현
//인터페이스를 구현한 클래스는 멤버변수, 생성자 등 나머지 부분은 클래스와 동일하게 사용가능

public class CoffeeMachine implements Machine {





    @Override
    public void takeCoffee() {
        System.out.println("커피나옴");

    }

    @Override
    public void takeMilk() {
        System.out.println("우유나옴");
    }



}

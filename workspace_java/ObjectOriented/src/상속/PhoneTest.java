package 상속;

public class PhoneTest {
    public static void main(String[] args) {

        MobilePhone mp = new MobilePhone();
        SmartPhone sp = new SmartPhone();

        //부모클래스로는 자식클래스의 객체를 받을 수 있음
        //자식클래스로는 부모클래스의 객체를 받을 수 없음
        //다형성으로 생성된 객체는 부모클래스의 변수, 메서드만 사용가능
        MobilePhone mp2 = new SmartPhone(); // mp2는 스마트폰임
        //왼 부모 오른 자식
        //mp2.playApp(); 안됨
        mp2.sendMsg();

        //SmartPhone sp2= new MobilePhone(); <안됨 근데 비유로 배우면 안된댔는데
        // 이게 다형성이래 . ? ? ? ? ???

        //남자와 여자는 사람인 것은 맞지만 사람이라고 해서 남자인지 여자인지는 모릅니다.
        //남자와 여자가 스마트폰(자식) , 사람이 모바일폰 (부모)



    }
}

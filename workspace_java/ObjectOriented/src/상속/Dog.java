package 상속;


//우리 병원에는 강아지, 고양이, 송아지 3종류의 동물 관리
//병원에는 총 10개의 케이지 존재 >
//단, 3종류의 동물 수는 항상 변함

class Animal{

    public void bark(){
        System.out.println("운다");
    }
}

public class Dog extends Animal {
    @Override//어노테이션 :개발자의 실수방지
    public void bark(){//부모클래스의 메서드와 자식클래스의 메서드명 동일하게 씌운게 오버라이딩
        System.out.println("멍멍");
    }
    public void aaa(){

    }

}

class Cat extends Animal{
    public void bark(){
        System.out.println("애옹");
    }

}

class Cow extends Animal{
    public void bark(){
        System.out.println("음메");
    }

}

class Duck extends Animal{
    public void back(){
        System.out.println("꽤액");
    }
}

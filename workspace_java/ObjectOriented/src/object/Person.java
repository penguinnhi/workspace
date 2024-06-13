package object;

import java.sql.SQLOutput;

public class Person {
    String name;
    int age;

    //부모클래스의 메서드를 오버라이딩 하는 중
    //오버라이딩이 되려면 메서드명 일치, 매개변수 정보 일치
    /*public boolean equals(Object obj){
        return
    }*/

    @Override
    public boolean equals(Object obj) {
        if (name.equals( ((Person)obj).name ) && age == ((Person)obj).age ){//** ㅇㄹㅇ
            return true;
        }
        else return false;
    }

    //toString() 오버라이딩
    //객체를 문자열로 표현 > 모든 멤버변수의 값을 문자열로 표현하면 됨 ?
    /*@Override
    public String toString() {

    }*/

    @Override
    public String toString() { //**********************************
        return "Person{" +
                "이름='" + name + '\'' +
                ", 나이=" + age +
                '}';
    }


}


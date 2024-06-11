package class_basic.car;


//접근제한자 : 클래스, *메서드, 멤버변수*에서 사용.
//1.public : 프로젝트 내에 존재하면 접근 가능
//2.default : 같은 패키지 내에 있으면 접근 가능 (공백)
//3.protected : ?
//4.private : 변수, 메서드가 선언된 클래스 안에서만 접근 가능

//멤버변수에는 무조건 private
//메서드는 무조건 public

//멤버변수? 클래스 안에서 선언된 거
// 지역변수? 메서드 안에서 선언된 거

import java.time.OffsetDateTime;

public class Phone {
    private int price;
    private String modelName;
    String brand;
    //멤버변수인듯


    //생성자
    public Phone(){
        this.price=0;
        this.modelName="";
    }

    public void setPrice(int price){
        if (price<0){
            this.price=0;
        }
        else {
            this.price=price;
        }

    }


}


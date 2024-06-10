package class_basic.car;

import java.sql.SQLOutput;

public class Car {

    String brand;
    String modelName;
    String carNumber;
    int price;
    String owner;


    //자동차의 속성 하나하나를 각각 변경하는 메소드 만들기

    public void setBrand(String b){
        brand=b;
    }

    public void setModelName(String mn){
        modelName=mn;
    }

    public void setCarNumber(String cn){
        carNumber=cn;
    }

    public void setPrice(int p){
        price=p;
    }

    public void setOwner(String o){
        owner=o;
    }


    //자동차의 속성 출럭
    public void printCarInfo(){

        System.out.println("제조사 - "+brand);
        System.out.println("차 이름 - "+modelName);
        System.out.println("차량 번호 - "+carNumber);
        System.out.println("가격 - "+price);
        System.out.println("소유주 - "+owner);


    }


}

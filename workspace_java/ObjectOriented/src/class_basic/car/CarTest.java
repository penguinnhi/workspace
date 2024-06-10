package class_basic.car;

public class CarTest {
    public static void main(String[] args) {
        Car c1=new Car();

        //c1의 변수를 출력
        System.out.println(c1.brand);
        System.out.println(c1.price);

        //c1 변수의 값 변경
        c1.brand="제네시스";
        c1.modelName="GV70";
        c1.carNumber="97가0675";
        c1.price=2000;
        c1.owner="유지현";

        System.out.println(c1.brand);
        c1.printCarInfo();

        System.out.println();

        Car c2=new Car();
        c2.printCarInfo();

        System.out.println();

        c2.setBrand("현대");
        c2.setModelName("에쿠스");
        c2.setCarNumber("60가9775");
        c2.setPrice(2000);
        c2.setOwner("유지현");

        c2.printCarInfo();


    }

}

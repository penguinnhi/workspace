package basic;

public class PhoneTest {

    public static void main(String[] args) {
        // PhoneBox의 타입 인자는 Phone,MobilePhone,SmartPhone만 들어올 수 있음
//        PhoneBox<String> p1=new PhoneBox<>();
//        p1.phoneTest("phone");

        PhoneBox<Phone> box1=new PhoneBox<>();
        PhoneBox<MobilePhone> box2=new PhoneBox<>();
        PhoneBox<SmartPhone> box3=new PhoneBox<>();


    }

}

package basic;

// <T extends Phone> : T를 Phone 클래스나 Phone 클래스를 상속한 클래스만 허용하도록 타입인자 제한
public class PhoneBox<T extends Phone> {
    private T data;

    public void phoneTest(T data){
        this.data=data;
        data.call(); // phone 클래스를 받아왔기 때문에 가능함
//        data.sendMsg();


    }

}

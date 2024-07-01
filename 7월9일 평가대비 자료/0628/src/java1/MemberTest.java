package java1;

public class MemberTest {
    public static void main(String[] args) {
        Member mem1=new Member();

        mem1.setInfo("자바","java","abcd1234",20);

        mem1.showInfo();

        mem1.isLogin("java","abcd1234");

        mem1.isLogin("java","abcd");


    }



}

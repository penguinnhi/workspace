package class_basic;

public class AccountTest {
    public static void main(String[] args) {

        Account a1=new Account();

        //객체를 초기화(최초의 값 세팅,객체 생성 시 최초 1회 실행)하는 메서드 호출
        /*a1.initAccount();

        a1.printAccount();
        */

        a1.printAccount();

        Account acc1=new Account(1);
        acc1.printAccount();




    }

}

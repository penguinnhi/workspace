package test;

public class BankPrint {
    public static void main(String[] args) {
        Bank bb=new Bank();

        System.out.println(bb.getClient("1111-1111","이순신"));
        //bb.getClient("1111-2222","이순신");

        System.out.println(bb.getOver(30000));
        //bb.getOver(30000);

    }
}

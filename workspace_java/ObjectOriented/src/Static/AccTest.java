package Static;

public class AccTest {
    public static void main(String[] args) {

        //이율이라는 통이 따로 있음
        Account ac1=new Account("1234",10000);
        Account ac2=new Account("1222",20000);
        Account ac3=new Account("1233",50000);
        Account ac4=new Account("1244",30000);
        Account ac5=new Account("1255",80000);

        System.out.println(ac1);

        Account.iyul=10.0;

        System.out.println(ac1);


    }
}

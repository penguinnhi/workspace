package 상속;

public class ManTest {
    public static void main(String[] args) {

        BusinessMan businessMan=new BusinessMan();

        System.out.println(businessMan.company);
        businessMan.tellCompany();

        System.out.println(businessMan.name);
        businessMan.tellName();


    }
}

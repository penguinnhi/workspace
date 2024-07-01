package java1;

public class CalTest {
    public static void main(String[] args) {
        Calculate cal=new Calculate(); //객체생성

        cal.setNumber(3,4);

        System.out.println("두 수의 합 : "+cal.getSum());

        System.out.println("두 수 중 큰 수 : "+cal.getMax());

        System.out.println("두 수의 평균 : "+cal.getAvg());


    }
}

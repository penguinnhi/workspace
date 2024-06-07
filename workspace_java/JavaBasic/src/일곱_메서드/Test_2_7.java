package 일곱_메서드;

/*
* 실수를 매개변수로 받아, 그 수의 제곱 값을 리턴하는 메소드를 만들고 사용해보세요.
* */

public class Test_2_7 {
    public static void main(String[] args) {
        double result=test7(2);
        System.out.println(result);
    }

    public static double test7(double a){
        return a*a;
    }
}

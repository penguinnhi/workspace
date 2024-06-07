package 일곱_메서드;

/*
* scanner로 입력받은 두 정수를 매개변수로 받아,
* 두 정수의 곱을 리턴하는 메소드를 선언하고 호출하여 결과를 호학인해보세요.
* */

public class Test_2_2 {
    public static void main(String[] args) {
        int result=getSum(2,3);
        System.out.println(result);
    }

    public static int getSum(int a,int b){
        return a*b;
    }

}

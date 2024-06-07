package 일곱_메서드;

/*
* 두 정수를 매개변수로 받아,
* 두 정수 중 큰 숫자를 리턴하는 메소드를 선언하고 사용해보세요.
* */

public class Test_2_3 {
    public static void main(String[] args) {
        int result = max(8,5);
        System.out.println(result);

    }

    public static int max(int a,int b){
        int max=a>b?a:b;
        int min=a<b?a:b;
        return max;
    }

}

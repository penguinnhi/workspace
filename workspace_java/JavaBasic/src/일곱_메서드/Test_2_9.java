package 일곱_메서드;

/*
* 한 정수를 매개변수로 받아, 1부터 매개변수로 받은 수까지 중 홀수의 합을 리턴하는 메소드를 선언하고 사용해보세요.
* */

public class Test_2_9 {
    public static void main(String[] args) {
        int result=test9(8);
        System.out.println(result);
    }
    public static int test9(int a){
        int sum=0;
        for (int i=1;i<a+1;i++){
            if (i%2==1){
                sum+=i;
            }
        }
        return sum;

    }
}

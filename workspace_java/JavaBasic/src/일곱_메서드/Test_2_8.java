package 일곱_메서드;

/*
* 세 정수를 매개변수로 받아, 세 정수의 평균을 리턴하는 메소드를 선언하고 사용해보세요.
* */

public class Test_2_8 {
    public static void main(String[] args) {
        double result=test8(5,5,5);
        System.out.println(result);

    }
    public static double test8(int a, int b, int c){

        int[] arr={a,b,c};
        int sum=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            //sum =0 > sum+arr[0](=1) 0+1=1
            //arr[i] = 이게 곧 a, b, c 다
        }

        return sum/arr.length;
    }

}

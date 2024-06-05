package 일곱_메서드;

import java.util.Scanner;

public class Test_1_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("정수1 : ");
        int a=sc.nextInt();
        System.out.print("정수2 : ");
        int b=sc.nextInt();
        test13(a,b);

        test14(50);


    }


    //scanner로 정수 두 개를 입력받아,
    // 입력받은 두 수를 매개변수로 사용하여
    // 두 수의 합을 출력하는 메소드를 선언하고,
    // 호출해보세요.
    public static void test13(int a,int b){

        System.out.println("정수 1 : "+a);
        System.out.println("정수 2 : "+b);

        int c=a+b;
        System.out.println("합 : "+c);

        System.out.println();
    }


    public static void test14(int a){
        //삼항연산자
        //참 또는 거짓을 판단 가능한 항 ? 앞에 있는 조건이 참일 때 실행할 내용 : 거짓일 때 실행할 내용 ;
        int x=10 >5 ? 1: 2;

        System.out.print("입력받은 수 : "+a);
        System.out.println();
        if (a%2==0){
            System.out.println("짝수입니다");
        }
        else {
            System.out.println("홀수입니다");
        }

        System.out.println(a%2==0 ? "짝수" : "홀수");

    }

}

package 네번째_조건문;

import java.util.Scanner;

public class 예제_3 {
    public static void main(String[] args) {
        //키보드로 정수 하나를 입력받아서 입력받은 정수가 3의 배수이면서 5의 배수일 때만 1을 출력

        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int num=sc.nextInt();

        if(num%3==0&&num%5==0){
            System.out.println("콜라중독ㄷㄷ");
        }

    }
}

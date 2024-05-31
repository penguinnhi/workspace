package 네번째_조건문;

import java.util.Scanner;

public class 예제_2 {
    public static void main(String[] args) {
        //키보드로 정수 하나를 입력받아
        // 입력받은 정수가 짝수이면 1, (=2로 나누었을 때 나머지가 0 = (num%2==0)
        // 홀수면 2 (2로 나누었을 때 나머지가 1)

        Scanner sc=new Scanner(System.in);
        System.out.print("입력:");
        int num=sc.nextInt();

        if (num%2==0){
            System.out.println("1");
        }
        else{
            System.out.println("2");
        }


    }
}

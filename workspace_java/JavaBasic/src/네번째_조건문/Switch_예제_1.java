package 네번째_조건문;

import java.util.Scanner;

public class Switch_예제_1 {
    public static void main(String[] args) {
        //키보드로 정수 하나를 입력받아 ,
        //입력받은 값이 짝수이면 1 출력 홀수이면 2 출력 그 밖에는 0 출력

        Scanner sc=new Scanner(System.in);
        System.out.print("정수입력 : ");
        int a=sc.nextInt();
        int z=a%2;

        switch (z){
            case 0 :
                System.out.println(1);
                break;
            case 1 :
                System.out.println(2);
                break;
            default:
                System.out.println(0);
        }
    }
}

package 네번째_조건문;

import java.util.Scanner;

public class 예제_1 {
    public static void main(String[] args) {
        //키보드로 정수를 입력받아
        //정수가 10보다 클 때만
        // '10보다 큽니다' 라는 문자열을 출령하세요

        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int num=sc.nextInt();

        if(num>10){
            System.out.println("10보다 큽니다.");
        }
        else{
            System.out.println("콜라중독인듯?");
        }

    }
}

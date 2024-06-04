package If_문제_심화;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("1~99 사이의 정수를 입력하시오>>");
        int num=sc.nextInt();

        int a,b;
        a=num/10;
        b=num%10;


        int clapCnt=0; //박수의 횟수


        //십의 자리가 3,6,9면 clapCnt를 1증가 (a%3==0 && a!=0)
        //일의 자리가 3,6,9면 clapCnt를 1증가

        if (a==3||a==6||a==9){
            clapCnt++;
        }
        if (b==3||b==6||b==9) {
            clapCnt++;
        }

        //clapCnt의 값에 따라 출력
        switch (clapCnt){
            case 1 :
                System.out.println("박수 짝");
                break;
            case 2:
                System.out.println("박수 짝짝");
        }




    }
}

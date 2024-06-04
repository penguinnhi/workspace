package 네번째_조건문;

import java.util.Scanner;

public class Switch_test3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("첫 번째 수 : ");
        int a=sc.nextInt();
        System.out.print("두 번째 수 : ");
        int b=sc.nextInt();
        System.out.print("연산자 : ");
        String c=sc.next();

        if (c.equals("+")){
            System.out.println(a+c+b+" = "+(a+b));
        }
        else if (c.equals("-")){
            System.out.println(a+c+b+" = "+(a-b));
        }
        else if (c.equals("*")){
            System.out.println(a+c+b+" = "+(a*b));
        }
        else if (c.equals("/")){
            System.out.println(a+c+b+" = "+((double)a/b));
        }
        else {
            System.out.println("연산자를 잘못 입력하셨습니다.");
        }

    }
}

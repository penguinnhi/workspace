package class_basic.calculator;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("수 1 : ");
        int a=sc.nextInt();
        System.out.print("수 2 : ");
        int b=sc.nextInt();
        System.out.print("연 : ");
        String c=sc.next();
        System.out.println();

        // c1 객체의 a와 b를 키보드로 입력받은 값으로 변경

        Calculator c1=new Calculator();
        c1.setNumber(a,b);


        System.out.println("결과");

        if (c.equals("+")){
            System.out.println(a+c+b+"="+(c1.getAdd()));
        }
        else if (c.equals("-")){
            System.out.println(a+c+b+"="+(c1.getSub()));
        }
        else if (c.equals("*")){
            System.out.println(a+c+b+"="+(c1.getMul()));
        }
        else if (c.equals("/")){
            System.out.println(a+c+b+"="+(c1.getDiv()));
        }
        else {
            System.out.println("ㅗ");
        }


    }
}

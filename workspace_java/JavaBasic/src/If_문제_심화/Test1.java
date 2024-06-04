package If_문제_심화;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        int a,b,c;


        Scanner sc=new Scanner(System.in);
        System.out.print("변 1 : ");
        a=sc.nextInt();
        System.out.print("변 2 : ");
        b=sc.nextInt();
        System.out.print("변 3 : ");
        c=sc.nextInt();

        if ((a+b)>c && (b+c)>a && (a+c)>b){
            System.out.println("삼각형~~ ");
        }
        else {
            System.out.println("안됨");
        }

    }
}

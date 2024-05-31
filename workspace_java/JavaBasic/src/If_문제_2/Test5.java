package If_문제_2;

import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("-출력-");
        System.out.print("첫번째 수 : ");
        int a=sc.nextInt();
        System.out.print("두번째 수 : ");
        int b=sc.nextInt();

        if (a>b){
            System.out.println(a+">"+b);
        }
        else if (b>a){
            System.out.println(b+">"+a);
        }



    }
}

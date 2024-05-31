package If_문제_2;

import java.util.Scanner;

public class Test5_1 {
    public static void main(String[] args) {
        int max; //큰 수 저장
        int min; //작은 수 저장


        Scanner sc=new Scanner(System.in);
        System.out.println("-출력-");
        System.out.print("첫번째 수 : ");
        int a=sc.nextInt();
        System.out.print("두번째 수 : ");
        int b=sc.nextInt();


        if (a>b){
            max=a;
            min=b;
        }
        else {
            max=b;
            min=a;
        }

        System.out.println(max+">"+min);
    }
}

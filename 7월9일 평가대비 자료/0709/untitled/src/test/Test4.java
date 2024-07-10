package test;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int num= sc.nextInt();

        int a,b,c;
        a=num/100;
        b=(num%100)/10;
        c=num%10;

        int cnt=0;

        if(a==3||a==6||a==9){
            cnt++;
        }
        if(b==3||b==6||b==9){
            cnt++;
        }
        if(c==3||c==6||c==9){
            cnt++;
        }

        switch (cnt){
            case 0:
                System.out.println("박수 0번");
                break;
            case 1 :
                System.out.println("박수 1번");
                break;
            case 2 :
                System.out.println("박수 2번");
                break;
            case 3 :
                System.out.println("박수 3번");
        }


    }


}

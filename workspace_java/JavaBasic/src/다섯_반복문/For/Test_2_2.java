package 다섯_반복문.For;

import java.util.Scanner;

public class Test_2_2 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("입력1 : ");
        int a=sc.nextInt();
        System.out.print("입력2 : ");
        int b=sc.nextInt();

        //큰 수와 작은 수 결정

        int max,min;
        int i;

        int sum=0;
        if (a>b){
            max=a;
            min=b;
            for (i=min+1; i<max; i++){
                sum+=i;
            }
            System.out.println(sum);
        }
        else {
            max=b;
            min=a;
            for (i=min+1;i<max;i++){
                sum+=i;
            }
            System.out.println(sum);
        }



    }
}

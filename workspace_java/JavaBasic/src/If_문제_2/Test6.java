package If_문제_2;

import java.util.Scanner;

public class Test6 {
    public static void main(String[] args) {

        int max;
        int mid;
        int min;


        Scanner sc=new Scanner(System.in);


        System.out.println("-출력-");
        System.out.print("첫번째 수 : ");
        int a=sc.nextInt();
        System.out.print("두번째 수 : ");
        int b=sc.nextInt();
        System.out.print("세번째 수 : ");
        int c=sc.nextInt();


        //a가 가장 큰 수라면
        if (a>b && a>c ){
            max=a;
            if (b>c){
                mid=b;
                min=c;
            }
            else{
                mid=c;
                min=b;
            }

        }
        //b가 가장 큰 수라면
        else if (b>a && b>c){
            max=b;
            if (a>c){
                mid=a;
                min=c;
            }
            else{
                mid=c;
                min=a;
            }
        }
        //c가 가장 큰 수라면
        else {
            max=c;
            if (b>a);
            mid=b;
            min=a;

        }

        System.out.println(max+">"+mid+">"+min);

    }
}

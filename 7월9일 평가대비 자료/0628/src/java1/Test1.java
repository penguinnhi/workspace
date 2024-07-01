package java1;

import java.sql.SQLOutput;
import java.util.Scanner;


//세 정수를 Scanner로 입력받아 큰 수부터 나열하여 출려가는 프로그램을 작성. 중복X
//완
public class Test1 {


    public static void main(String[] args) {
        int max=0;
        int mid=0;
        int min=0;

        Scanner sc=new Scanner(System.in);

        System.out.print("수 1 : ");
        int a=sc.nextInt();
        System.out.print("수 2 : ");
        int b=sc.nextInt();
        System.out.print("수 3 : ");
        int c=sc.nextInt();

        if (a>b && a>c){
            max=a;
            if (b>c){
                mid=b;
                min=c;
            }
            else {
                mid=c;
                min=b;
            }
        }
        else if (b>c && b>a){
            max=b;
            if (a>c){
                mid=a;
                min=c;
            }
            else {
                mid=c;
                min=a;
            }
        }
        else if (c>a && c>b){
            max=c;
            if (a>b){
                mid=a;
                min=b;
            }
            else {
                mid=b;
                min=a;
            }
        }

        System.out.println(max+">"+mid+">"+min);

    }


}

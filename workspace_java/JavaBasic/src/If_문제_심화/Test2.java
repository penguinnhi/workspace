package If_문제_심화;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("점 (x,y)의 좌표를 입력하시오>>");
        int x=sc.nextInt();
        int y=sc.nextInt();

        if (x>=50 && x<=100 && y>=50 && y<=100){

            System.out.println("사각형 안에 점이 있습니다. ");
        }


        else {
            System.out.println("안됨");
        }
    }
}

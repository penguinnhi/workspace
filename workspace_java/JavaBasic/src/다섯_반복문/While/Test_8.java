package 다섯_반복문.While;

import java.util.Scanner;

public class Test_8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int i=sc.nextInt();
        int a=1;

        while (a<=i){
            if (a%2==0){
                System.out.println(a);
            }
            a++;
        }

    }
}

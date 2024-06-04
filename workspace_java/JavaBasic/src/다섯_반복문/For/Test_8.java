package 다섯_반복문.For;

import java.util.Scanner;

public class Test_8 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int i=sc.nextInt();
        int cnt=0;

        for (int a=1;a<=i;a++){
            if (a%2==0){
                cnt+=1;
            }
        }
        System.out.println(i+"까지의 수 중 짝수의 개수 : "+cnt);
    }

}


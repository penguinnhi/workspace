package 다섯_반복문.While;

import java.util.Scanner;

public class Test_8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int i=sc.nextInt(); //10을 받았다고 가정
        int a=1;
        int count=0;

        while (a<=i){ // a<i+1
            if (a%2==0){
                count+=1; //count++; count=count+1;
            }
            a++;
        }
        System.out.println(i+"까지의 수 중 짝수의 개수 : "+count);

    }
}

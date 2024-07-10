package test;

import java.util.Arrays;
import java.util.Scanner;

public class Test5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("수 1 : ");
        int num1= sc.nextInt();
        System.out.print("수 2 : ");
        int num2= sc.nextInt();
        System.out.print("수 3 : ");
        int num3= sc.nextInt();


        int[] arr1=new int[3];
        int cntS=0;
        int cntB=0;
        int cntA=0;

        for (int i=0;i<arr1.length;i++) {
            arr1[i]=(int) (Math.random() * 8+1);

            for (int e=0;e<i;e++) {
                if (arr1[e] == arr1[i]) {
                    i--;
                }
            }

            cntA++;


            if (arr1[0]==num1) {
                cntS++;
                System.out.println(cntS + "스트라이크" +cntB+"볼");

            }

            else if (arr1[1]==num2) {
                cntS++;
                System.out.println(cntS+"스트라이크"+cntB+"볼");
            }

            else if (arr1[2] == num3) {
                cntS++;
                System.out.println(cntS+"스트라이크"+cntB+"볼");
            }

            else if (arr1[i]==num1||arr1[i]==num2||arr1[i]==num3){
                cntB++;
                System.out.println(cntS+"스트라이크"+cntB+"볼");
            }

            else if(arr1[i]==num1&&arr1[i]==num2&&arr1[i]==num3){

                System.out.println(cntA+"회만에 정답");
            }

            else{

            }


        }
        System.out.println(Arrays.toString(arr1));



    }
}

package 여섯_배열;

import java.util.Scanner;

public class Test_2_1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int a=sc.nextInt();

        int[] arr=new int[a];

        for (int i=0;i<a;i++){
            arr[i]=i+1;
        }

        //총합
        int sum = 0;

        for(int i = 0 ; i < arr.length ; i++){
            sum = sum + arr[i];
        }

        double result = sum / (double)arr.length;
        System.out.println(result);
/*

        // int total=0;
        //total=total+arr[i];
        double avg=total/a;

        System.out.println(avg);
*/



    }
}

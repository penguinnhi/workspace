package 여섯_배열;

import java.util.Scanner;

public class Test_10 {
    public static void main(String[] args) {

        int[] arr1=new int[5];
        Scanner sc=new Scanner(System.in);

        for (int i=0;i< arr1.length;i++){
            System.out.print("입력 : ");
            int a=sc.nextInt();
            arr1[i]=a;


        }
        for (int i=0;i<arr1.length;i++) {
            System.out.println(arr1[i]);

        }


    }
}

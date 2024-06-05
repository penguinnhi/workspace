package 여섯_배열;

/*1. scanner로 정수 하나를 입력받아, 입력받은 정수만큼의 길이를 갖는 배열을 생성하고
배열에 각 요소에 1 ~ 입력 받은 정수로 값을 저장한다.
예를 들어 5를 입력했으면 길이가 5인 배열을 만들고 각 요소에 1,2,3,4,5가 들어가야 한다.
그 후 배열에 들어간 수의 평균을 출력해보자. */


import java.util.Scanner;

public class Test_2_1 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("배열의 크기 : ");
        int length=sc.nextInt();

        int[] arr=new int[length];

        for (int i=0;i<length;i++){
            arr[i]=i+1;
        }


        //총합
        int sum = 0;

        for(int i = 0 ; i < arr.length ; i++){    //*************모르겟음
            sum = sum + arr[i];
        }

        //for(int e:arr){
        // sum=sum+e;
        // }


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

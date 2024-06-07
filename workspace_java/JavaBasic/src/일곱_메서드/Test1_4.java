package 일곱_메서드;

import java.sql.SQLOutput;
import java.time.OffsetDateTime;

public class Test1_4 {
    public static void main(String[] args) {

        test15(5,10);

        test16(5);

        test17(2,5);

        test18(1,10);

        test19("치킨",3);

    }

    public static void test15(int a,int b){
        if (a%2==0&&b%2==0){
            System.out.println("두 수는 짝수입니다");
        }
        else if (a%2==0||b%2==0){
            System.out.println("한 수만 짝수입니다");
        }
        else {
            System.out.println("두 수는 홀수입니다");
        }

        System.out.println();
    }

    public static void test16(int a){
        for (int i=0; i<a+1; i++){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println();
    }

    public static void test17(int a,int b){
        int i=0;
        int max=a>b?a:b;
        int min=a<b?a:b;

        /*
        if (a>b){
            max=a;
            min=b;
        }
        else{
            max=b;
            min=a;
        }
        */


        int[] arr=new int[i];
        for (i = min+1; i<max ; i++){

            System.out.print(i+" ");

        }
        System.out.println();
    }

    public static void test18(int a,int b){
        int i=0;
        int max=a>b?a:b;
        int min=a<b?a:b;
        int cnt=0;

        int[] arr=new int[i];
        for (i = min+1; i<max ; i++){
            if (i%5==0){
                cnt++;
            }
        }
        System.out.println(cnt);


    }

    public static void test19(String str,int a){//**********모름
        String result="";

        for (int i=0; i<a; i++){
            result=result+str;
        }
        System.out.println(result);
        //공백=공백+치킨
        //치킨=치킨+치킨
        //치킨치킨=치킨치킨+치킨
        System.out.println(str);

    }



}

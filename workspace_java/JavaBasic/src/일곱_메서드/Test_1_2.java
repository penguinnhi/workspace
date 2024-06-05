package 일곱_메서드;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test_1_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("test11 입력ㄱ : ");
        int a=sc.nextInt();
        test11(a);


        System.out.print("이름 : ");
        String name=sc.next();
        System.out.print("나이 : ");
        int age=sc.nextInt();
        System.out.print("주소 : ");
        String addr=sc.next();
        test10(name,age,addr);

    }

    public static void test11(int a){

        System.out.print(a);
        System.out.println();
    }


    public static void test12(String name,int age,String addr){


    }


    public static void test9_1(String name){
        System.out.println("이름은 "+name+"임");
    }
    public static void test9_2(int age){
        System.out.println("나이는 "+age+"임");
    }
    public static void test9_3(String addr){
        System.out.println("주소는 "+addr+"임");
    }


    public static void test10(String name,int age,String addr){
        System.out.println("출력결과");
        test9_1(name);
        test9_2(age);
        test9_3(addr);


    }

}

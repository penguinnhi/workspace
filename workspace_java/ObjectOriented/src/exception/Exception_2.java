package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try {

            System.out.print("첫 : ");
            int a=sc.nextInt();
            System.out.print("두 : ");
            int b=sc.nextInt();

            System.out.println(a/b);

        }catch (ArithmeticException exception){
            //Exception 숫자, 문자열 오류 다 잡음 모든 예외처리 클래스 받기 가능
            //InputMismatchException 문자열
            //ArithmeticException 숫자

            System.out.println("수학적 오류 발생");

        }
        catch (InputMismatchException exception){
            System.out.println("입력 자료형 불일치");
        }

        System.out.println("프로그램 종료");

    }
}

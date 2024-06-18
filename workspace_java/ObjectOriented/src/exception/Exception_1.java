package exception;


//예외처리
/*
* 예외처리 문법
* try{
*   예외가 발생할 수 있는 코드 작성
* }catch(Exception e){
*   예외 발생 시 실행 코드 작성
* }finally{
*   예외가 발생하든 하지않든 무조건 실행할 코드
* }
*
* */
//오류와 예외의 차이


import java.util.Scanner;

public class Exception_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try {

            System.out.print("첫 : ");
            int a = sc.nextInt();

            System.out.print("두 : ");
            int b = sc.nextInt();

            System.out.println(a/b);

            //try구문안에서 예외가 발생하면 거기까지만 실행되고 catch로 넘어감

        }catch (Exception e){ //클래스 객체 / 예외에 대한 정보가 들어있는 클래스

            System.out.println("오류 발생");
            //System.out.println(e.getMessage());//예외 발생 이유를 간략히 문자열로 알려줌
            //리턴타입 자료형 정말 중요합니다,,,,,,,,,,,,,,,,
            e.printStackTrace();

        }finally { //<생략 가능

        }

        System.out.println("프로그램종료");


        // <빨간색으로 글자 뜨는거 : 예외발생
        //첫10 두0
        //Exception in thread "main" java.lang.ArithmeticException: / by zero :
        //	at exception.Exception_1.main(Exception_1.java:20) : Exception_1 파일의 메인 메서드 20번째 줄에서 오류가 났다

        //첫5 두ㅎㅎㅎ
        //Exception in thread "main" java.util.InputMismatchException
        //	at java.base/java.util.Scanner.throwFor(Scanner.java:939)
        //	at java.base/java.util.Scanner.next(Scanner.java:1594)
        //	at java.base/java.util.Scanner.nextInt(Scanner.java:2258)
        //	at java.base/java.util.Scanner.nextInt(Scanner.java:2212)
        //	at exception.Exception_1.main(Exception_1.java:18)



    }
}

package 출력문;

public class Exam3 {
    public static void main(String[] args){
        //문자열은 반드시 쌍따옴표에 감싸서 작성
        System.out.println("안녕하세요");
        //숫자는 쌍따옴표에 감싸지 않아도 가능
        System.out.println(10); // 숫자로 인식
        System.out.println("10"); // 10이라는 문자로 인식

        System.out.println(10+10); // 연산 가능하면 연산 결과가 출력
        System.out.println("10"+"10");
        System.out.println("java"+"hello"); //문자끼리의 합은 문자를 연결
        System.out.println(10+"java"); //숫자와 문자의 합은 숫자를 문자로 간주하고 나열
        System.out.println(10+20+"java");
        System.out.println(10+"java"+20);
        System.out.println(5+"java"+5*10); //

        System.out.println(10>0);
        System.out.println(10<5);
        System.out.println(1==1);
        System.out.println(1!=1);
    }
}

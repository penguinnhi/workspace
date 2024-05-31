package 변수와자료형;


//**** 자료형이 다르면 데이터 저장 불가 !! *******

//자바는 크게 기본 자료형과 참조자료형으로 데이터의 형태를 구분
//기본 자료형 총 8개
//참조 자료형은 무한대

/*기본 자료형 (소문자
    정수 타입: byte, short, int, long
    실수 타입: float, double
    논리 타입: boolean
    문자 타입: char


 ------------------------------------
    문자열 타입: String !!!!! 기본 자료형 아님. 참조 자료형
*
*
* */


public class 자료형_1 {
    public static void main(String[] args) {
        System.out.println("잠온다");
        byte n1=100;
//        byte n2=1299; //바이트 범위초과 오류
        //int n=4=20.4
        double n3=20.4;

        //boolean 쌍따옴표 없음
        boolean b1=true;
        boolean b2=false;

        //문자(나)열 - 0개 글자 이상 + 쌍따옴표
        String s1="java";
        String s2="false";

        //문자(한 글자+홀따옴표)
        char c1='ㅗ';
        System.out.println("c1 = "+c1);
        char c2=66;
        System.out.println("c2 = "+c2);
        char c3='A';
        int c4=c3;
        System.out.println("c3 = "+c3);
        System.out.println("c4 = "+c4);


    }
}

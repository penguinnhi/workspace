package 일곱_메서드;

/*
* 두 문자열을 매개변수로 받아, 두 문자열의 나열결과를 리턴하는 메소드를 선언하고 사용해보세요.
* */

public class Test_2_4 {
    public static void main(String[] args) {
        String result=s1("ㅇㅇ","ㄴㄴ");
        System.out.println(result);
    }

    public static String s1(String a,String b){
        return a+b;

    }

}

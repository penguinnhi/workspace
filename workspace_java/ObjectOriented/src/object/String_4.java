package object;

public class String_4 {
    public static void main(String[] args) {

        //concat : 두 문자열을 나열
        String a="배고프다";
        String b="나는카레";
        System.out.println(b.concat("버섯카레"));


        //substring : 문자열에서 일부만 추출
        String str1="abcdefg";
        System.out.println(str1.substring(2)); //2번째 글자부터 추출
        System.out.println(str1.substring(2,4)); //2번째 글자부터 4번째 글자 앞까지 추출


        //length : 문자열 길이
        String str2="김치에카레";
        System.out.println(str2.length());


        String str3="김치,카레,버섯";
        String[] result=str3.split(",");
        System.out.println(result[1]);

    }

}

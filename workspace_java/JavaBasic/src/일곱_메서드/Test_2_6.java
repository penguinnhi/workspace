package 일곱_메서드;

/*
* 매개변수로 정수를 입력받아, 입력받은 정수를 문자열로 리턴하는 메소드를 선언하고 사용해보세요.
* */

public class Test_2_6 {
    public static void main(String[] args) {
        String result=test6(5);
        System.out.println(result);
    }
    public static String test6(int a){

        //문자열->정수
        int aa=Integer.parseInt("10");//10********************
        //정수->문자열
        String bbb=String.valueOf(10); //"10"

        return ""+a;



    }




}

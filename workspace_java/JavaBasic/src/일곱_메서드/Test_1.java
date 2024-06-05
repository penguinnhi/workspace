package 일곱_메서드;

public class Test_1 {
    public static void main(String[] args) {
        hi("안녕하세요");
        test2("반갑습니다","어서오세요");
        test3(3);
        test4("배고픔");
        test5(5,8);
        test6(5,8,3);
    }

    public static void hi(String hi){
        System.out.println(hi);
    }

    public static void test2(String second,String third){
        System.out.print(second+" ");
        System.out.println(third);
    }

    public static void test3(int a){
        System.out.println("정수 하나를 매개변수로 받아 어쩌구 : "+a);
    }

    public static void test4(String b){
        System.out.println("문자열 하나를 어쩌구 : "+b);
    }

    public static void test5(int a,int b){
        System.out.println("정수 두 개 어쩌구 : "+(a+b));
    }

    public static void test6(int a,int b,int c){
        System.out.println("정수 세 개 어쩌구 : "+(a*b*c));
    }


}

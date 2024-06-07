package 일곱_메서드;

/*
* 임의의 정수를 매개변수로 받아,
* 만약 매개변수로 받은 정수가 90 이상이면 ‘A’,
* 70 이상이면 ‘B’,
* 그 외의 수가 들어오면 ‘C’를 리턴하는 메소드를 선언하고 사용해보세요.
* */

public class Test_2_5 {
    public static void main(String[] args) {
        String result=i1(80);
        System.out.println(result);
    }

    public static String i1(int a){
        if (a>=90){
            return "A";
        }
        else if (a>=70){
            return "B";
        }
        else {
            return "C";
        }
    }


}

package 일곱_메서드;

public class 메서드_5 {
    public static void main(String[] args) {
        int result =getSum(2,3);
        System.out.println(result);

        double result2=getSum2(3,5);

    }
    //매개변수로 전달된 두 정수의 합을 리턴하는 메서드
    public static int getSum(int a,int b) {
        return a + b;
    }

    //매개변수로 전달된 두 정수의 합을 실수형태로 리턴하는 메서드
    public static double getSum2(int a,int b){
        //리턴 키워드는 항상 메서드의 마지막에 딱 한번만 실행 가능
        return a+(double)b;

        //print("웅앵") <- 리턴뒤에 오는건 실행 안됨

    }

}

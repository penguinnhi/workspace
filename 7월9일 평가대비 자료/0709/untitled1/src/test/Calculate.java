package test;

public class Calculate {
    int a;
    int b;

    //클래스가 가진 두 정수 데이터를 매개변수로 전달된 값으로 변경하는 기능
    public void setNumber(int num1,int num2){
        a=num1;
        b=num2;
    }

    //클래스가 가진 두 정수의 합을 리턴
    public int getSum(){
        int sum=a+b;
        System.out.println(sum);
        return sum;
    }

    //클래스가 가진 두 정수 중 큰 수를 리턴
    public int getMax(){
        int max=a>b?a:b;
        System.out.println(max);
        return max;
    }

    //클래스가 가진 두 정수 사이에 존재하는 정수들의 평균을 리턴
    //(클래스가 가진 두 정수는 범위에서 제외)
    public double getAvg(){
        double avg=(a+b)/2.0;
        return avg;
    }

}

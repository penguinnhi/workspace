package Interface.math;


//제공한 인터페이스와 같은 패키지에 MyMath라는 클래스를 생성하고
//MyMath 클래스는 아래에 제시한 MathUtil 인터페이스를 구현해야함
//MyMath 클래스에 인터페이스를 주석에 맞게 구현 ㄱ
public interface MathUtil {

    //매개변수로 받은 두 수 중 작은 수를 리턴
    int getMin(int a,int b);

    //매개변수로 받은 반지름을 가진 원의 둘레 리턴
    //단, 매개변수로 들어온 반지름이 음수라면 둘레는 0이 되어야 함
    //둘레 구하기 : 2 * 3.14 * 반지름
    double getCircleArea(int radius);

    //첫번째 매개변수로 받은 수의 n제곱 값을 리턴
    //수1 : 3 , 수2 : 4 , 결과 : 3*3*3*3
    int getMultiple(int num1,int n);


}

package Interface.math;

public class MathTest {
    public static void main(String[] args) {

        MyMath mm= new MyMath();

        System.out.println(mm.getMin(2,3));
        System.out.println(mm.getMultiple(2,3));
        System.out.println(mm.getCircleArea(5));

    }
}

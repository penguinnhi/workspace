package Interface.math;

public class MyMath_2 implements MathUtil{



    @Override
    public int getMin(int a, int b) {
        return a>b?b:a;
    }



    @Override
    public double getCircleArea(int radius) {
        return radius*2*Math.PI;
    }



    @Override
    public int getMultiple(int num1, int n) {

        int result=1;//*************
        for (int i=0;i<n;i++){
            result*=num1;//*******************
        }

        return result;
    }




}

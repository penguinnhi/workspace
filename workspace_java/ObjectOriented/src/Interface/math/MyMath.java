package Interface.math;

public class MyMath implements MathUtil {

    @Override
    public int getMin(int a, int b) {
        /*int max,min;
        if (a>b){
            min=b;
        }
        else {
            min=a;
        }
        return min;*/
        return a<b ? a:b;

    }

    @Override
    public double getCircleArea(int radius) {
        /*double d;
        if (radius<0){
            d=0;
        }
        else {
            d=radius*2*Math.PI;
        }

        return d;*/

        return radius<0?0:radius*2*Math.PI;

    }

    @Override
    public int getMultiple(int num1, int n) {//************************** ㅁㄹ


        int result=1;
        for (int i=0;i<n;i++){
            result = result*num1;
            //result*=num1;
        }
        return result ;


    }
}

package Interface.array;

public class MyArray_2 implements MyArrayUtil {


    @Override
    public double getTwoArrayAvg(int[] ar1, int[] ar2) {

        int sum1=0;
        for (int i:ar1){
            sum1+=i;
        }
        int sum2=0;
        for (int i:ar2){
            sum2+=i;
        }

        return (double)(sum1+sum2)/(ar1.length+ar2.length);
    }


    @Override
    public boolean isEvenArray(int[] array) {

        for (int e:array){
            if (e%2==1)
                return false;
        }
        return true;
    }




}

package Interface.array;


public class MyArray implements MyArrayUtil {

    @Override
    public double getTwoArrayAvg(int[] ar1, int[] ar2) {
        int[] nar=new int[ar1.length+ar2.length];

        for (int i=0;i<ar1.length;i++){
            nar[i]=ar1[i];
        }
        for (int i=0;i<ar2.length;i++){
            nar[i+ar1.length]=ar2[i];
        }
        int sum=0;
        for (int e:nar){
            sum+=e;
        }
        return sum/nar.length;
    }

    @Override
    public boolean isEvenArray(int[] array) {

        for (int e:array){
            return array[e] % 2 == 0;

        }
        return false;
    }


}

package Interface.array;


public class MyArray implements MyArrayUtil {

    @Override
    public double getTwoArrayAvg(int[] ar1, int[] ar2) {
        /*int[] nar=new int[ar1.length+ar2.length];

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
    }*/


        int sum1 = 0;
        for (int e : ar1) {
            sum1 += e;
        }
        int sum2 = 0;
        for (int i : ar2) {
            sum2 += i;
        }
        return (sum1 + sum2) / (double)(ar1.length + ar2.length);
    }



    @Override
    public boolean isEvenArray(int[] array) { //is 붙어있으면 대부분 리턴타입 boolean으로 씀
/*
        for (int e:array){
            return array[e] % 2 == 0;

        }
        return false;
        */

        for (int e:array){
            if (e%2==1){
                return false;
            }
        }

        return true;

    }


}

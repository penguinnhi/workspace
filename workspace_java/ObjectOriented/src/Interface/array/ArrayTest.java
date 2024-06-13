package Interface.array;

public class ArrayTest {
    public static void main(String[] args) {
        MyArray ma=new MyArray();

        int[] aa={1,2,3};
        int[] bb={2,4,6};

        System.out.println(ma.getTwoArrayAvg(aa,bb));
        System.out.println(ma.isEvenArray(aa));


    }
}

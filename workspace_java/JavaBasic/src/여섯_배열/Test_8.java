package 여섯_배열;

public class Test_8 {
    public static void main(String[] args) {

        int[] arr1=new int[10];
        int a=1;

        for (int i=0;i<arr1.length;i++){
            arr1[i]=a++; //i+1;
        }


        for (int i=0; i<arr1.length;i++){
            System.out.println(arr1[i]);
        }

    }
}

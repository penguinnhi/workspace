package 여섯_배열;

public class Test_2_6 {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={4,5,6};
        int[] nA=new int[arr1.length+arr2.length];

        for (int i=0;i< arr1.length;i++){
            nA[i]=arr1[i];
        }

        for (int i=0;i<arr2.length;i++){
            nA[i+arr1.length]=arr2[i];
        }

        for (int e:nA){
            System.out.print(e+" ");
        }




    }
}

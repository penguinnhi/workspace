package 여섯_배열;

//배열의 항목에서 최대값 구하기

public class Test_3_1 {
    public static void main(String[] args) {
        int max=0;
        int[] arr={1,5,3,8,2};

        for (int i =0;i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }

        System.out.println("max : "+max);
    }
}

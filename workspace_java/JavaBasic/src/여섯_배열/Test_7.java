package 여섯_배열;

public class Test_7 {
    public static void main(String[] args) {

        int[] arr1=new int[10];



        //모든 요소에 3을 저장
        for (int i=0;i< arr1.length;i++){
            arr1[i]=3;
        }


        //모든 요소를 출력
        for (int i=0; i<arr1.length; i++){
            System.out.println(arr1[i]); //윗 for에 넣어도 가능함
        }

    }
}

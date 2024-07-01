package java1;

//정수{5,11,20,40,30}의 초기값을 갖는 배열을 생성하고,
//해당 배열에서 가장 큰 값과 가장 작은 값을 출력하시오
public class Test3 {
    public static void main(String[] args) {

        int[] arr={5,11,20,40,30};

        int max=0;
        int min=arr[0];

        for (int a:arr){
            if (max<a){
                max=a;
            }
        }

        for (int i=0;i<arr.length;i++){
            if (min>arr[i]){
                min=arr[i];
            }


        }


        System.out.println("큰 값 : "+max);
        System.out.println("작은 값 : "+min);


    }


}

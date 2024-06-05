package 여섯_배열;

public class Test_11 {
    public static void main(String[] args) {

        int[] arr= {1,2,3,4,5,6,7,8};

        /*

        int cnt=0;

        for (int i=0;i<arr.length;i++){
            if (arr[i]%2==0){   // 꺼진 불도 다시 보기
                cnt+=1;
            }
        }
        System.out.println(cnt);

        */

        int cnt1=0;
        for (int e:arr){
            if (e%2==0){
                cnt1+=1;
            }
        }
        System.out.println(cnt1);


    }
}

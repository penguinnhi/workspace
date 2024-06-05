package 여섯_배열;

//기본자료형(특이)과 참조자료형(보편적)의 차이

//하나의 변수에는 하나의 값만 저장

public class 배열과기본자료형의차이 { // ******진짜중요함 그치만 문제푸는 데 지장없음.
    public static void main(String[] args) {
        /*int a1=10;
        int b1=a1;
        a1=20;
        System.out.println("a1 = "+a1); //20
        System.out.println("b1 = "+b1); //10
*/
        // 주소복사
        int[] a={1,3,5};
        int[] b=a;
        a[0]=10;
        b[2]=50;

        //a{10,3,5}
        //b{10,3,5} 외.

        for (int e:a){
            System.out.print(e+" ");
        }
        System.out.println();
        for (int e:b){
            System.out.print(e+" ");
        }


        //배열의 복사 .. 모양만복사 ? ? ? 각자의 주소가 잇음
        int[] c={1,2,3};
        int[] d=c.clone();



    }
}

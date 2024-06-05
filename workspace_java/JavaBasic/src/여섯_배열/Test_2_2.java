package 여섯_배열;

/*길이가 100인 배열을 만들고 각 요소의 값을 1 ~ 100으로 변경하자.
그 후 배열에 들어간 수 중 소수만 출력해보자.
(소수란 1과 자신의 수로만 나누어 떨어지는 수이다. ex> 2,3,5,7..)
 */


public class Test_2_2 {
    public static void main(String[] args) {

        int[] arr=new int[100];

        for (int i=0; i<100; i++) {
            arr[i] = i + 1;


        }
    }
}

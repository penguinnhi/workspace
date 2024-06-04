package 다섯_반복문.For;

public class Test_2_3 {
    public static void main(String[] args) {

        int sum=0;
        int i=0;

        for (i=1;i<100;i++ ){

            if (sum>300){
                break;
            }
            sum+=i;

        }



        System.out.println("300까지의 합 : "+sum);
        System.out.println("마지막으로 더해진 값 : "+i);

    }
}

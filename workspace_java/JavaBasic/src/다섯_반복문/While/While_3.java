package 다섯_반복문.While;

public class While_3 {
    public static void main(String[] args) {

       /* int i=10;
        while (i>=0){
            System.out.println(i);
            i--;


       }*/
/*
        int i =1;
        while (i<=20){
            System.out.println(i);
            i = i+2;

        }*/

        //1부터 5까지의 수 중에서 짝수만 출력
        int i=1;
        while (i<=5){
            //짝수만 출력
            if (i%2==0){
                System.out.println(i);
            }
            i++;
        }

    }


}

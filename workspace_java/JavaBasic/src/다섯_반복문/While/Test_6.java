package 다섯_반복문.While;

public class Test_6 {
    public static void main(String[] args) {
        int i =1;
        int count=0;


        while (i<=100){//(i<101)
            if (i%3==0){
                count+=1; // count++;

            }
            i++;

        }
        System.out.println("3의 배수인 수의 개수 : "+count);
    }
}

package 다섯_반복문.While;

public class Test_7 {
    public static void main(String[] args) {
        int i=1;
        int count=0;

        while (i<=100){ //i<101
            if (i%5==0){
                count+=1; //count++; count=count+1;

                System.out.print(i+" ");
            }
            i++;
        }
        System.out.println();
        System.out.println("5의 배수의 개수 : "+count);
    }
}

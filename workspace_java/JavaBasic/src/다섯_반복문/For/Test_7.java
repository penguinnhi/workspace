package 다섯_반복문.For;

public class Test_7 {
    public static void main(String[] args) {
        int cnt=0;
        for (int i=1; i<101; i++){
            if (i%5==0){
                cnt+=1;
                System.out.println("5의 배수 : "+i);
            }
        }
        System.out.println("5의 배수의 개수 : "+cnt);
    }
}

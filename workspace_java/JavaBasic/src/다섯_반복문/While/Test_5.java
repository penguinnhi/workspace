package 다섯_반복문.While;

public class Test_5 {
    public static void main(String[] args) {
        int i=1;
        int sum=0;


        //(i<11)
        while (i<=10){
            sum=sum+i; // sum += i;
            i++;
        }
        System.out.println(sum);
    }
}
//0+1=1
//i=2
//1+2=3
//i=3
//3+3=6
//4
//6+4=10
//


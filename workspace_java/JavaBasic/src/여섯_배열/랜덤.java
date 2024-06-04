package 여섯_배열;

public class 랜덤 {
    public static void main(String[] args) {

        //1~10의 랜덤한 정수

        //0.0<=x<1.0 실수
        //double rand=Math.random();


        //0.0<=x<10.0 실수
        //Math.random()*10;
        //1.0<=x<11.0 실수
        //Math.random()*10+1;
        //1.0<=x<11.0 정수
        int rand=(int)(Math.random()*10+1);

        System.out.println(rand);
    }
}

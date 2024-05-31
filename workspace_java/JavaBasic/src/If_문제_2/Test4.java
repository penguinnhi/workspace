package If_문제_2;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("국어점수 : ");
        int kor=sc.nextInt();
        System.out.print("영어점수 : ");
        int eng=sc.nextInt();
        System.out.print("수학점수 : ");
        int math=sc.nextInt();

        int total;
        double avg;

        total=kor+eng+math;
        avg=(kor+eng+math)/3;

        System.out.println();
        System.out.println("-결과-");
        System.out.print("총점 : "+total);
        System.out.println();
        System.out.print("평균 : "+avg);
        
    }
}

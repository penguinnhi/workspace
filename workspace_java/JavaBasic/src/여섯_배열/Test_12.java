package 여섯_배열;

//간단한 성적처리 시스템을 만들어보자.
// 국어, 영어, 수학점수를 입력받아
// 각 과목에 대한 점수 및 총점, 평균을 출력하는 프로그램을 만들어보자.
// 반드시 배열을 사용하도록 한다.


import java.util.Scanner;

public class Test_12 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("국어점수 : ");
        int korScore=sc.nextInt();
        System.out.print("영어점수 : ");
        int engScore=sc.nextInt();
        System.out.print("수학점수 : ");
        int mathScore=sc.nextInt();
        int total=0;

        int[] score= {korScore,engScore,mathScore};

        for (int i=0;i< score.length;i++){
            total=total+score[i];

        }

        double avg=(double) total/ score.length;

        System.out.print("총점 : "+total);
        System.out.println();
        System.out.print("평균 : "+avg);

    }
}

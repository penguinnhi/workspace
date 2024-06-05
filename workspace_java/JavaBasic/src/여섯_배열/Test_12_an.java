package 여섯_배열;

//간단한 성적처리 시스템을 만들어보자.
// 국어, 영어, 수학점수를 입력받아
// 각 과목에 대한 점수 및 총점, 평균을 출력하는 프로그램을 만들어보자.
// 반드시 배열을 사용하도록 한다.

import java.util.Scanner;
import java.util.SimpleTimeZone;

public class Test_12_an {
    public static void main(String[] args) {
        //변수선언
        Scanner sc=new Scanner(System.in);
        //0:국 1:영 2:수 3:총
        int[] scores=new int[4];
        //과목명 저장
        String[] subjects={"국어","영어","수학"};

        double avg;


        //점수입력(0~100점 입력까지 무한 입력)

        for (int i=0; i<(scores.length-1); i++) {

            while (true) {
                System.out.print(subjects[i]+"점수 : ");
                scores[i] = sc.nextInt();

                if (scores[i] >= 0 && scores[i] <= 100)
                    break;
            }

        }

        //총점 및 평균계산

        for (int i=0; i<(scores.length-1); i++) {
            scores[scores.length-1]=scores[scores.length-1]+scores[i];

        }

        avg=scores[scores.length-1]/(double)(scores.length-1);

        System.out.println();
        System.out.println("--입력한 정보입니다.");
        for (int i=0;i< subjects.length;i++){
            System.out.println(subjects[i]+" 점수 = "+ scores[i]);
        }
        System.out.println("총점 = "+scores[scores.length-1]);
        System.out.println("평균 = "+avg);







        }
}

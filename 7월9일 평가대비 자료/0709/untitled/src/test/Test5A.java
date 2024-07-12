package test;

import java.util.Arrays;
import java.util.Scanner;

public class Test5A {
    public static void main(String[] args) {

        //  2) 3스트라이크가 될 때까지 프로그램을 지속되어야 하며 실행 결과 3스트라이크를 맞춘 도전 횟수를 출력
        //  3) Scanner를 통해 입력한 세 수와 요구사항 1)에서 생성한 랜덤한 세 수를 비교하여 스트라이크와 볼을 결정한다.
        // 4) 키보드로 입력한 수가 1)에서 만든 배열의 수와 일치하며 위치도 같다면 스트라이크, 수는 일치하지만 위치가 다르면
        //볼이다.
        Scanner sc=new Scanner(System.in);


        // 문제
        // 1) 먼저 크기가 3인 정수형 배열을 생성하고 배열의 각 요소에 1 ~ 9사이의 랜덤한 정수를 저장한다. 중복 불허.
        int[] baseball = new int[3];

        for (int i=0;i<baseball.length;i++){
            int rand = (int)(Math.random()*9 + 1);
            baseball[i]=rand;

            //중복검사
            for (int e=0;e<i;e++){
                if (baseball[i]==baseball[e]){
                    i--;
                    break; //반복문안의 break : 가장 가까운 반복문이 실행종료됨
                }
            }
        }



        //대답
        int[] answer = new int[3];

        System.out.println(Arrays.toString(baseball));
        System.out.println("게임시작");



        int tryCnt=0;
        while (true){ //3스트라이크가 될 때까지 지속되어야 하는거라 무한루프
            tryCnt++;
            System.out.print(tryCnt+">>");

            answer[0]=sc.nextInt();
            answer[1]=sc.nextInt();
            answer[2]=sc.nextInt();

            //정답 대조
            //baseball = []
            //answer = []
            int strike = 0;
            int ball = 0;

            for (int i=0; i<baseball.length;i++){
                for (int j=0; j<answer.length;j++){

                    if (baseball[i]==answer[j] && i==j){ //들어있는 거도 같고 순번도 같음
                        strike++;
                    }
                    else if (baseball[i]==answer[j]){
                        ball++;

                    }

                }
            }

            System.out.println(strike+"스트라이크 "+ball+"볼");
            if (strike==3)break;

        }
        System.out.println(tryCnt+"번만에 정답");


    }




    //결과 예시
//    만들어진 숫자 : 5 1 7 <- 문제 이해를 위한 임시출력
//    숫자를 정했습니다. 게임을 시작합니다.
//      1 >> 2 9 3
//       0스트라이크 0볼
//      2 >> 1 2 3
//       0스트라이크 1볼
//      3 >> 7 1 5
//       1스트라이크 2볼
//      4 >> 5 1 7
//       3스트라이크 0볼
//      4회만에 정답을 맞췄습니다


}

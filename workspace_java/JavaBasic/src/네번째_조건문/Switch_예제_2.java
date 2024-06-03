package 네번째_조건문;


/* 주민등록번호의 7번째 자리는 성별을 나타낸다.
*   7번째 자리의 수가 1또는3 남성 2또는4 여성
*   키보드로 주민등록번호 7번째자리를 입력받아
*   남자일경우 남성 여자일경우 여성
*   잘못된 숫자를 입력하면 오류 출력
* */

import java.util.Scanner;

public class Switch_예제_2 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("입력 : ");
        int a=sc.nextInt();



        switch (a){
            case 1,3 :
                System.out.println("남");
                break;
            case 2,4 :
                System.out.println("여");
                break;
            default:
                System.out.println("오류");
        }

    }
}

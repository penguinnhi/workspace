package 네번째_조건문;

/*  switch case break
*   switch(변수){
*       case 값1 :
*       case 값2 :
*       case 값3 :
*   }
*
* */


public class Case_1 {
    public static void main(String[] args) {

        System.out.println("시작");
        int num=8;


        switch (num){ //시작지점을 알려주는 것
            case 1 : //num 값이 1일 때의 실행 내용
                System.out.println(1);
                break; //break문을 만나면 switch문 종료
            case 3 :
                System.out.println(3);
                break;
            case 5 :
                System.out.println(5);
                System.out.println(5);
                break;
            case 7 :
                System.out.println(7); //마지막 switch문에는 break 사용 안함
                break;
            default:// 그 밖에는, 그 외에는, 조건이 맞지않으면
                System.out.println("해당 없음");
        }

        System.out.println("종료");
    }
}

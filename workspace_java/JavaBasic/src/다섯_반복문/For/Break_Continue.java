package 다섯_반복문.For;

public class Break_Continue {
    public static void main(String[] args) {
        //반복문(while,for)에서의 break 역할
        //break문을 만나면 가장 가까이에 있는 반복문을 벗어난다.


        for (int i=1; i<11; i++){

            if (i==5){
                break;
            }

            System.out.println(i);



        }


        System.out.println();

        //반복문(while,for)에서의 continue 역할
        //continue를 만나는 순간 반복문의 끝으로 이동한다./ 해당 회차만 스킵
        for (int i=1; i<11; i++){

            System.out.println(i);
            if (i==3){
                continue;
            }

            }





    }
}

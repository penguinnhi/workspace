package 여섯_배열;

import 다섯_반복문.For.For_1;

import java.awt.font.FontRenderContext;

public class 배열_4 {
    public static void main(String[] args) {

        int[] arr1=new int[5]; //0 0 0 0 0

        //배열에 값을 저장할 때도 출력과 마찬가지와 각 요소에 데이터를 저장
        arr1[1]=10;
        arr1[3]=5;

        for (int i=0; i< arr1.length; i++){
            System.out.println(arr1[i]);
        }




    }
}

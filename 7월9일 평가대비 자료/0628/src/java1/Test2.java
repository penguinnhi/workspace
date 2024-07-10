package java1;

import java.util.Arrays;

//정수 6개 저장 배열만들고 배열 요소에 1~46사이의 난수 저장
//중복값 X
//배열에 난수를 저장한 후 배열의 모든 요소의 값을 출력하세요
//완
public class Test2 {
    public static void main(String[] args) {

        System.out.println(getRandom());
    }

    public static String getRandom(){
        int[] random=new int[6];

        for (int i=0;i<random.length;i++) {
            random[i]=(int) (Math.random() * 45+1);
        }
        //이게 난수를 배열에 넣은거야

        return Arrays.toString(random);

    }

}

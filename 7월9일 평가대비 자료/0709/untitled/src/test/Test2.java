package test;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {

        System.out.println(getRandom());
    }

    public static String getRandom(){
        int[] random=new int[6];

        for (int i=0;i<random.length;i++) {
            random[i]=(int) (Math.random() * 45+1);
        }

        return Arrays.toString(random);

    }

}

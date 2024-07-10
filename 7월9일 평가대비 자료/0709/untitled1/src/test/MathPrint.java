package test;

import java.sql.SQLOutput;

public class MathPrint {
    public static void main(String[] args) {
        MathUtilImpl mm1=new MathUtilImpl();

        System.out.println(mm1.isEven(5,5,10));
        //mm1.isEven(1,2,3);

        System.out.println(mm1.getSumFromOne(3));
        //mm1.getSumFromOne(20);

        int[] arr={1,2,3};
        System.out.println(mm1.getArraySum(arr));
        //mm1.getArraySum(arr);

    }

}

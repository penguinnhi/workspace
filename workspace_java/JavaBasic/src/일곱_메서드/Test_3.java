package 일곱_메서드;

import java.util.Arrays;


public class Test_3 {
    public static void main(String[] args) {
        /*int[] a={1,3,5};
        test5(a);*/

        //test2(2);

        /*test3(10);*/

        //System.out.println(test4());

        /*String r5=test5(2);
        System.out.println(r5);*/

        //System.out.println(test5_2(5));

        /*int[] r6={2,5,3,8,4};
        test6(r6);
        System.out.println(test6(r6));*/

       /* String[] r7={"카리나","윈터"};
        String result = test7(r7);
        System.out.println(result);

        */


        /*int[] r8_1={2,5,3,4};
        int[] r8_2={3,1,8};
        Arrays.toString(test8(r8_1,r8_2));
        test8(r8_1,r8_2);
        System.out.println();*/

        int[] r9={1,2,3,4,5,6,7,8,9,10};
        int[] ans=test9_a(r9);
        System.out.println(Arrays.toString(ans));

    }


    //정수형 배열 하나를 매개변수로 받아 배열의 요소 중 홀수를 제거한 새로운 배열을 리턴하는 메소드를 만들어보세요.
    public static int[] test9_a(int[] ar){//**********ㅁㄹ
        //매개변수로 넘어온 배열 요소 중 짝수의 개수
        int cnt=0;
        for (int e:ar){
            if (e%2==0){
                cnt+=1;
            }
        }

        int[] resultArr=new int[cnt]; //짝수만 저장될 배열을 생성

        int index=0;
        for (int i=0;i<ar.length;i++){
            if (ar[i]%2==0){
                resultArr[index]=ar[i];
                index++;

            }
        }
        return resultArr;


    }




    //정수형 배열 두 개를 매개변수로 받아 두 배열의 모든 요소를 갖는 새로운 배열을 리턴하는 메소드를 만들고 호출해보세요.
    public static int[] test8(int[] ar1,int[] ar2){


        int[] na=new int[ar1.length+ar2.length];
        for (int i=0; i<ar1.length;i++){
            na[i]=ar1[i];
        }
        for (int i=0;i<ar2.length;i++) {
            na[ar1.length + i] = ar2[i];

        }
        return na;

    }


    //문자열 배열을 매개변수로 받아 배열에 저장된 모든 문자열을 나열하여 리턴하는 메소드를 만들고 호출해보세요.
    public static String test7(String[] a2){//****모름
        String aa="";
        for (int i=0;i<a2.length;i++){
            aa=aa+a2[i];

        }
        return aa;

    }


    //정수형 배열을 매개변수로 받아 배열의 모든 요소 중 최대값을 리턴하는 메소드를 만들고 호출해보세요.
    public static int test6(int[] arr){
        int max=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }


    //정수 하나를 매개변수로 받아, 매개변수가 짝수면 true, 홀수면 false를 리턴하는 메소드를 만들고 활용해보자.
    public static String test5(int a){
        if (a%2==0){
            return "true";
        }
        else {
            return "false";
        }

    }

    public static boolean test5_2(int a){
        return a%2==0?true:false;
        //= a%2==0;
    }


    //Math.random() 메소드를 활용하여 1~ 50의 수 중 랜덤한 정수를 리턴하는 메소드를 만들고 호출해보자.


    public static int test4(){
        return (int) (Math.random()*50+1);
    }


    //정수 하나를 매개변수로 받아, 1 ~ 100까지의 수 중에서 매개변수로 받은 수의 배수를 출력하는 메소드를 만들고 호출해보세요.
    public static void test3(int a){
        for (int i=1;i<101;i++){
            if (a%i==0){
                System.out.println(i);
            }
        }

    }


    //정수 하나를 매개변수로 받아 해당 정수의 구구단을 출력하는 메소드를 만들고 호출해보세요.
    public static void test2(int a){
        for (int i=1;i<10;i++){
            System.out.println(a+"*"+i+"="+(a*i));
        }

    }



    //정수형 배열을 매개변수로 받아 배열의 모든 요소를 출력하는 메소드를 만들고 호출하세요.
    public static void test5(int[] arr){
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

}

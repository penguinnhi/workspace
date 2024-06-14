package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiTest_1 {
    public static void main(String[] args) {

        System.out.println(1);
        //1
        List<String> lis=new ArrayList<>();

        lis.add("ㅇㅇ");
        lis.add("ㄴㄴ");
        lis.add("ㅗㅗ");

        for (int i=0;i<lis.size();i++){
            System.out.println(lis.get(i));
        }


        System.out.println(2);
        //2
        Scanner sc=new Scanner(System.in);
        //int a,b,c,d,e;

        List<Integer> lint=new ArrayList<>();

        for (int i=0;i<5;i++){//*****************
            System.out.print("정수입력 : ");
            int num=sc.nextInt();
            lint.add(num);
        }

        /*lint.add(a=sc.nextInt());
        lint.add(b=sc.nextInt());
        lint.add(c=sc.nextInt());
        lint.add(d=sc.nextInt());
        lint.add(e=sc.nextInt());*/

        int sum=0;
        for (int i:lint){
            sum+=i;
        }
        System.out.println(sum);


        System.out.println(3);

        //3
        List<String> name=new ArrayList<>();

        name.add("장길산");
        name.add("성춘향");
        name.add("홍길동");

        for (int i=0;i<name.size();i++){
            if (name.get(i).equals("홍길동"))
                System.out.println("해당 이름이 존재합니다.");

        }



        System.out.println(4);
        //4
        List<Integer> inrand=new ArrayList<>();

        //리스트에 1~100까지의 랜덤한 정수
        //(Math.random()이라는 메소드는 0 <= x < 1의 실수를 리턴)
        for (int i=0;i<10;i++){
            int num=(int)(Math.random()*100+1);
            inrand.add(num);
        }

        /*inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);
        inrand.add(Math.random()*10+1);*/

        int cnt=0;
        for (int i=0;i<inrand.size();i++){
            if (i%2==0){
                cnt++;
                System.out.println(inrand.get(i));
            }
        }
        System.out.println(cnt);




    }
}

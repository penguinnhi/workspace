package class_basic.Value;

import java.util.Scanner;

public class Value {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("수1 : ");
        int a=sc.nextInt();
        System.out.print("수2 : ");
        int b=sc.nextInt();
        System.out.print("연 : ");
        String c=sc.next();

        switch (c){
            case "+":
                Add add=new Add();
                add.setValue(a,b);
                System.out.println(a+c+b+"="+add.calculate());
            break;

            case "-":
                Sub sub=new Sub();
                sub.setValue(a,b);
                System.out.println(a+c+b+"="+sub.calculate());
            break;

            case "*":
                Mul mul=new Mul();
                mul.setValue(a,b);
                System.out.println(a+c+b+"="+mul.calculate());
            break;

            case "/":
                Div div=new Div();
                div.setValue(a,b);
                System.out.println(a+c+b+"="+div.calculate());
            break;

            default:
                System.out.println("ㄴㄴ");

        }
    }


}

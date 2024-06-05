package 일곱_메서드;

public class Test_1_1 {
    public static void main(String[] args) {
        test7(10,5);
        test8("김","수한무");
        test9_1("김");
        test9_2(20);
        test9_3("수한무");
        test10("김수한무",20,"두루미와 거북이");
    }

    public static void test7(int a,int b){
        double c=a/b;
        double d=a%b;
        System.out.println("7.두 정수의 나눗셈의 몫 : "+c);
        System.out.println("7.두 정수의 나눗셈의 나머지 : "+d);

    }

    public static void test8(String a,String b){
        String[] c={a,b};
        for (String d : c){
            System.out.print(d+" ");
        }
        //a+b.. .하면 됨 ,,,,,,,,,
        System.out.println();
    }

    public static void test9_1(String name){
        System.out.println("9. 이름은 "+name+"임");
    }
    public static void test9_2(int age){
        System.out.println("나이는 "+age+"임");
    }
    public static void test9_3(String addr){
        System.out.println("주소는 "+addr+"임");
    }


    public static void test10(String name,int age,String addr){
        System.out.println("10 -출력결과");
        test9_1(name);
        test9_2(age);
        test9_3(addr);


    }



}

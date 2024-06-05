package 일곱_메서드;

public class 메서드_4 {
    public static void main(String[] args) {
        introduce("야이야이야 그렇게 살아가고 그렇게 후회하고 눈물도 흘리고오 야이야이야",20,"집");

        String a="벌써 일년";
        int b=40;
        String c="처음이라 그래 며칠 뒤엔 괜찮아져";

        introduce(a,b,c);

    }
    public static void introduce(String name,int age,String addr){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        System.out.println("주소 : "+addr);

    }


}

package object;

public class String_1 {
    public static void main(String[] args) {
        //문자열 객체 생성 방법
        String name1="java";
        String name2=new String("java");

        //String 객체의 특이점 , 참조자료형은 같은게 맞음 String이 달라서 특이한거
        String name3=name1;
        name1="python";
        System.out.println(name1);//python
        System.out.println(name3);//java
        


    }
}

package class_basic.book;

public class BookTest {
    public static void main(String[] args) {
        Book book=new Book("파","랑",20);
        System.out.println(book.title);

        Book book2=new Book("천","개",10);
        System.out.println(book2.title);

        //기본자료형
        int num = 5;
        int num2=num;
        double num3=num2;

        double num4=5.5;
        //int num5=num4; <안됨

        int num6=7;
        //String a=num6; <안됨

        Book book3=book;
        System.out.println(book.title);//파
        System.out.println(book3.title);//파
        book.title="흐르는";
        System.out.println(book.title); //흐르는
        System.out.println(book3.title);//흐르는
        //기본자료형과 참조자료형의 결과가 다름



    }
}

package class_basic.book;

public class Book {
    String title;
    String writer;
    private String publisher;
    int price;

    public Book(){
        this.title="";
        this.writer="";
        this.publisher="";
        this.price=0;
    }//this 생략해도 됨
/*

    public Book(String title,String writer,int price){
        this.title=title;
        this.writer=writer;
        this.price=price;

    }//this 생략하면 안됨

*/

    public Book(String title, String writer, int price) {
        this.title = title;
        this.writer = writer;
        this.price = price;
    }//자동으로 만들기



}

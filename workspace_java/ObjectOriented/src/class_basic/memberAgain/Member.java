package class_basic.memberAgain;

//생성자-4-13,14

public class Member {
    private String name;
    private String id;
    private String password;
    private int age;
    //선언

    public Member(String name,String id){
        this.name=name;
        this.id=id;
    }

    public void setName(String name,String id){
        this.name=name;
        this.id=id;
    }

    Member user1=new Member("홍길동","hong");
    //생성자,외부에서 받은 값으로 초기화



}

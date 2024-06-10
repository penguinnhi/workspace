package class_basic.member;

public class Member {

    String name;
    String id;
    String password;
    int age;

    //9

    public void setMemberInfo(String name1,String id1,String pw1,int a1){
        name=name1;
        id=id1;
        password=pw1;
        age=a1;
    }
    //10_a 이름,아이디,비번,나이 네 개의 변수 값을 모두 변경하는 메서드 1개

    public void setName(String n){
        name=n;
    }
    //12

    public void setId(String i){
        id=i;
    }

    public void setPassword(String pw){
        password=pw;
    }

    public void setAge(int ag){
        age=ag;
    }

    //10?

    public void printMemInfo(){
        System.out.println("이름 : "+name);
        System.out.println("아이디 : "+id);
        System.out.println("비밀번호 : "+password);
        System.out.println("나이 : "+age);
    }//11?


    public static void main(String[] args) {
        Member m1=new Member();
        m1.name="김수한무"; //12

        System.out.println(m1.name);



        System.out.println();



        Member m2=new Member();
        m2.setName("김조");
        m2.setId("tork");
        m2.setPassword("545465");
        m2.setAge(30);

        m2.printMemInfo();//13?
    }

}

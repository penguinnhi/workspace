package java1;

public class Member {
    private String name;
    private String id;
    private String pw;
    private int age;


    //모든 필드의 값을 매개변수로 받은 값으로 변경하는 기능
    public void setInfo(String name,String id,String pw,int age){
        this.name=name;
        this.id=id;
        this.pw=pw;
        this.age=age;
    }

    //모든 변수의 값을출력하는 기능
    public void showInfo(){
        System.out.println(name);
        System.out.println(id);
        System.out.println(pw);
        System.out.println(age);
    }

    //로그인 가능 여부를 결정하는 메서드 (로그인 가능 시에만 true)
    public boolean isLogin(String id,String pw){
        if (id.equals("java")&&pw.equals("abcd1234")){
            System.out.println("로그인 가능");
            return true;
        }
        else {
            System.out.println("로그인 불가능");
            return false;
        }
    }



}

package class_basic.man;

public class Man {

    private String name;
    private int age;
    private String address;
    //1

    public Man(String name,int age,String address){
        this.name=name;
        this.age=age;
        this.address=address;
    }
    //2 모든 값을 변경할 수 있는 생성자

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public void setAddress(String address){
        this.address=address;
    }
    //3 멤버 각각의 값을 변경하는 메소드를 3개를 만드세요. ************************
    // setter : 멤버변수 각각의 값을 변경하는 메서드
    // setter의 이름은 set변수명으로 반드시 지정해야함

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getAddress(){
        return address;
    }
    //4 ? 각 멤버의 값을 리턴하는 메소드를 3개 만드세요. ***********************
    // getter : 멤버변수 각각의 값을 return 받는 메서드
    //getter는 반드시 get변수명으로 반드시 지정해야함

    public void printManInfo(){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        System.out.println("주소 : "+address);
    }
    //5



}

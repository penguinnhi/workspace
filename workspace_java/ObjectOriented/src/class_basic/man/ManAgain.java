package class_basic.man;

public class ManAgain {

    private String name;
    private int age;
    private String address;


    public ManAgain(String name,int age,String address){
        this.name=name;
        this.age=age;
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printManInfo(){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        System.out.println("주소 : "+address);
    }

}

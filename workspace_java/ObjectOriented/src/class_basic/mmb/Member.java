package class_basic.mmb;

public class Member {
    private String name;
    private String id;
    private String password;
    //1-선언

    public Member(){
        this.name="";
        this.id="";
        this.password="";
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getPassword(){
        return password;
    }

    public void setName(String name){
        if (name.equals("")){
            name="";
        }
        else {
            this.name=name;
        }

    }
    public void setId(String id){
        if (id.equals("")){
            id="";
        }
        else {
            this.id=id;
        }

    }
    public void setPassword(String password){
        if (password.equals("")){
            password="";
        }
        else {
            this.password=password;
        }

    }
    //1


    public void displayInfo(){
        System.out.println("이름 : "+name);
        System.out.println("아이디 : "+id);
        System.out.println("비밀번호 : "+password);

    }
    //2



}

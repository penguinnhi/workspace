package class_basic.student;

//학생클래스

public class Stu {
    private String name;
    private int age;
    private String grade;
    private String tel;

    public Stu(String name, int age, String grade, String tel) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getTel() {
        return tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void showInfo(){
        System.out.println("이름 : "+name);
        System.out.println("나이 : "+age);
        System.out.println("연락처 : "+tel);
        System.out.println("학점 : "+grade);
    }//학생의 모든 정보 출력




}

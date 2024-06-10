package class_basic;

public class StudentTest {
    public static void main(String[] args) {

        Student stu1=new Student();

        System.out.println(stu1.name);
        System.out.println(stu1.age);
        System.out.println(stu1.score);

        stu1.introduce();
        stu1.setName("?머라는지몰루겟는데 ");
        stu1.introduce();
        stu1.setAge(20);
        stu1.introduce();

    }
}

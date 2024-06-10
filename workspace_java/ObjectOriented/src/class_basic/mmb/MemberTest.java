package class_basic.mmb;

public class MemberTest {
    public static void main(String[] args) {

        Member m1=new Member();

        m1.setName("자바");
        m1.setId("java");
        m1.setPassword("123");

        m1.displayInfo();
    }
}

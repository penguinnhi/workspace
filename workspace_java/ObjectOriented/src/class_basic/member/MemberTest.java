package class_basic.member;

public class MemberTest {
    public static void main(String[] args) {
        //객체가 뭔데

        Member m0=new Member(); // <<< 이게 객체

        m0.setMemberInfo("나","tt","dfd",54);
        m0.printMemInfo();

        System.out.println();

        m0.setName("김메서드");
        m0.printMemInfo();
    }
}

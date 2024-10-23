import java.util.Optional;

public class Optional_5 {
    public static void main(String[] args) {
        MemberVO member=new MemberVO("고길동",43);

        Optional<MemberVO> op1=Optional.of(member);

        // 회원 정보가 null이 아니면 회원의 이름을 출력
        if (member!=null){
            System.out.println(member.getName());
        }

        op1.ifPresent(m-> System.out.println(m.getName()));

        // 첫번째 매개변수 : 데이터가 존재할 때 Consumer<T> -> void X (T t)
        // 두번째 매개변수 : 데이터가 존재하지 않을 때 Runnable<T> -> void run()
        op1.ifPresentOrElse(
                mem-> System.out.println(mem.getName())
                , ()-> System.out.println("회원의 이름 정보가 없습니다.") );

    }

}

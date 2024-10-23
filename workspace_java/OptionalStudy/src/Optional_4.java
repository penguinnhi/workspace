import java.util.Optional;

public class Optional_4 {
    public static void main(String[] args) {

        Optional<String> op=Optional.of("KimBap");

        // map() 함수에 이어서 orElse() 메서드를 사용하면 데이터가 null 일 때 실행 내용을 작성할 수 있다.
        // 주의사항 : orElse() 메서드까지 사용하면 리턴타입은 Optional이 아니라 데이터가 리턴된다.
        String result = op.map(s->s.toString()).orElse("empty data");
        System.out.println(result);


    }
}

import java.util.Optional;

public class Optional_2 {
    public static void main(String[] args) {

        Optional<String> op1=Optional.of("떡볶이");
        Optional<String> op2=Optional.ofNullable(null);

        // 데이터가 존재할 때 어떤 내용을 실행할지 작성하는? 메서드
        // ifPresent() 메서드의 매개변수 : Consumer<T>
        // Consumer<T> -> void x(T t)
        op1.ifPresent(str-> System.out.println(str));
        op2.ifPresent(str-> System.out.println(str));

    }
}

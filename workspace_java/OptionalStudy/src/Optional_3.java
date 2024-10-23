import java.util.Optional;

public class Optional_3 {
    public static void main(String[] args) {

        Optional<String> op = Optional.of("Kim Bap");

        // Function<T> -> R x(T t)
        // map() 함수는 내용 실행 결과를 다시 Optional 상자에 담아서 리턴
        Optional<String> result1 = op.map((str)->str.toLowerCase());
        System.out.println(result1.get());

        String result2 = op.map(str->str.toLowerCase()).get();

        // ------

        Optional<String> op2=Optional.of("Kim Bap");

        // 대문자로 바꾸고 . 공백을 공백 없는 걸로 교체
        String result3=op2.map(str->str.toUpperCase()).map(str->str.replace(" ","")).get();
        System.out.println(result3);


    }
}

import javax.swing.text.html.Option;
import java.util.Optional;

public class Optional_1 {
    public static void main(String[] args) {
        String str1="떡볶이";
        String str2=null;

        // 객체를 Optional 상자에 넣기
        Optional<String> op1 = Optional.of(str1); // null을 허용하지 않을 객체
        Optional<String> op2 = Optional.ofNullable(str2); // null을 허용할 객체

        if (op1.isPresent()) {
            //isPresent() : 상자에 데이터가 존재하는지 확인

            System.out.println(op1.get()); // get() : 상자의 데이터 읽기

        }

        if (op2.isPresent()) {
            //isPresent() : 상자에 데이터가 존재하는지 확인

            System.out.println(op2.get()); // get() : 상자의 데이터 읽기

        }
    }
}

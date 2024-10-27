import java.util.Arrays;
import java.util.List;

public class Stream_6 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("황시목","한여진","최빛","서부지검");

        // Function<T> -> R apply(T t)
        // BinaryFunction<T> -> R apply(T t,T t)
        // Operator<T> -> T x(T t)
        // BinaryOperator<T> -> T x(T t,T t)
        String data = list.stream()
                .reduce("",(a,b)-> a.length() > b.length() ? a : b );
                // reduce 첫번째 매개변수 : list의 0번째 요소 추가


        System.out.println(data);



    }
}

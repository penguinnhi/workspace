
// 중간 연산 : filter(), map(), mapToInt()
// 최종 연산 : sum(), forEach(), collect(), count(), reduce(),
// 리턴타입 OptionalInt : [average(), min(), max()]

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class Stream_5 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        int sum =list.stream().mapToInt(num->num) // int x(T t) => Integer에서 int로 바꾸기
                .sum();
        long count = list.stream().mapToInt(num->num).count();


        OptionalInt min = list.stream().mapToInt(num->num).min();

        System.out.println(min.getAsInt()); // 데이터 없으면 오류남
        min.ifPresent( num -> System.out.println(num) );



    }
}

import java.util.Arrays;
import java.util.List;

public class Stream_3 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("떡볶이","주먹밥","치킨","콜라","치킨무");

        list.stream().map( str -> str.length() ) // 3,3,2,2,3 => integer : sum으로 못 받음
                .forEach(a-> System.out.println(a));



        list.stream().mapToInt( str -> str.length() ) // int apply(T t)
                .sum(); // int만 호출 가능



//        printAll("김","수","한","무","두루미","와","거북이");

    }

    // 매개변수로 문자열이 몇개 들어올지 불확실 : ...
    public static void printAll(String... s){
        for (String e : s){
            System.out.println(e);
        }

        Arrays.stream(s).forEach(a-> System.out.println(a));

    }

}

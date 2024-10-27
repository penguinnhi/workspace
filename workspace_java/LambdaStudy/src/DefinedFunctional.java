import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 정의되어있는 함수형 인터페이스 연습용 클래스
public class DefinedFunctional {
    //Predicate<T> 미사용 메서드
    // 1. 매개변수로 정수형 리스트가 들어오면 리스트의 요소 중 짝수만 출력
    public static void printEvenOfList(List<Integer> list){
        for (int e :list){
            if (e%2==0){
                System.out.print(e+" ");
            }
        }
    }

    // 2. 매개변수로 정수형 리스트가 들어오면 리스트의 요소 중 홀수만 출력
    public static void printOddOfList(List<Integer> list){
        for (int e :list){
            if (e%2==1){
                System.out.print(e+" ");
            }
        }
    }

    // 3. 매개변수로 정수형 리스트가 들어오면 리스트의 요소 중 짝수만 합 출력
    public static void printEvenSumOfList(List<Integer> list){
        int result=0;
        for (int e :list){
            if (e%2==0){
                result+=e;
            }
        }
        System.out.println(result+" ");
    }



    //Predicate<T> -> boolean test(T t) 연습용 메서드

    public static void printOfList(List<Integer> list, Predicate<Integer> P){
        for (int e:list){
            if (P.test(e)){
                System.out.println(e);
            }
        }
    }


    //Supplier<T> -> T get() 연습용 메서드
    // 두번째 매개변수로 전달된 n개의 정수를 갖는 리스트를 생성 및 리턴
    public static List<Integer> makeIntList(Supplier<Integer> s,int n){
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(s.get());
        }
        return list;
    }


    // Function<T,R> -> R apply(T t) 연습용 메서드
    public static List<Integer> getIntListFromString(Function<String,Integer> f,List<String> list){
        List<Integer> result=new ArrayList<>();

        for (String e:list){
            result.add(f.apply(e));
        }

        return result;
    }




}

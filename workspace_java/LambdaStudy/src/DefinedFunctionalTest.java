import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefinedFunctionalTest {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        DefinedFunctional.printEvenOfList(list);
        DefinedFunctional.printOddOfList(list);
        DefinedFunctional.printEvenSumOfList(list);


        Predicate<Integer> p= (a)->a%2==0;
        DefinedFunctional.printOfList(list,p);

        DefinedFunctional.printOfList(list,(num)->num%2==0); // 짝
        DefinedFunctional.printOfList(list,(num)->num%2!=0); // 홀
        DefinedFunctional.printOfList(list,(num)->num>3);

        System.out.println();

        // list에서 짝수만 삭제
//        for (int i=0;i<list.size();i++){
//            if (list.get(i)%2==0){
//                list.remove(i);
//                i--;
//            }
//        }

        // 함수형 인터페이스 사용으로 변환
        Predicate<Integer> p1=(num)->num>2;
        list.removeIf(p1);

        list.removeIf(num->num>2);

        list.forEach(num-> System.out.println(num));
        list.forEach(System.out::println);


        //짝수만 삭제됐는지 확인
        for (int e:list){
            System.out.print(e+" ");
        }


        System.out.println();


        //Supplier<T> -> T get()
        Supplier<Integer> s=()->{
            Random rand=new Random();
            return rand.nextInt(50); // 1~50까지의 난수 생성
        };

        List<Integer> result = DefinedFunctional.makeIntList(s,5);
        result.forEach(num-> System.out.print(num+" "));


        // Consumer<T> -> void accept(T t)
        list.forEach(num-> System.out.println(num));

        list.forEach(num->{
            num=num+5;
        });



        // Function<T,R> -> R apply(T t)
        List<String> list1=new ArrayList<>();
        list1.add("개굴개굴 개구리");
        list1.add("삐약삐약 병아리");
        list1.add("꽤액꽤액 오오리");
        list1.add("멍멍왈왈 강아지");

        DefinedFunctional.getIntListFromString( str-> str.length() ,list1);



    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Map_1 {
    public static void main(String[] args) {

        //데이터에 순번이 존재, 데이터 중복 가능
        List<String> list = new ArrayList<>();

        //데이터가 key와 value 한 쌍으로 저장됨
        //Map<key,value>
        Map<Integer,String> map=new HashMap<>();
        Map<String,String> map2=new HashMap<>();

        //Map에 데이터 저장
        map.put(1,"Wkdsksek");
        map.put(2,"whwrkxrhdy");
        map.put(3,"dd");

        map2.put("a","hihi");

        //map에 저장된 데이터 읽기 key값으로 읽기
        //map.get() =>이렇게 나오는건 value값임
        System.out.println(map.get(1));
        System.out.println(map2.get("a"));


    }
}

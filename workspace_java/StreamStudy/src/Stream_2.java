import java.util.ArrayList;
import java.util.List;

public class Stream_2 {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

        list.add(new Student("고길동",20));
        list.add(new Student("장길산",100));
        list.add(new Student("박희동",50));

        // 스트림을 사용해서 list에 저장된 학생 중 점수가 80점 이상인 학생만 걸러내는 코드 작성
        list.stream().filter(a-> a.getScore()>=80 ).forEach(s-> System.out.println(s));



    }

}

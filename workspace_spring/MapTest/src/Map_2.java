import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class Map_2 {
    public static void main(String[] args) {
        //학생 객체 3명 생성 후 3명의 학생을 map에 저장하시오
        //이때 key는 각 학생의 학번으로 지정

        Student stu1=new Student(1,"aa");
        Student stu2=new Student(2,"bb");
        Student stu3=new Student(3,"cc");

        Map<Integer,Student> map=new HashMap<>();

        map.put(stu1.getStuNum(),stu1);
        map.put(stu1.getStuNum(),stu2);
        map.put(stu1.getStuNum(),stu3);

        //key가 2번인 학생의 학생 이름 출력
        System.out.println(map.get(2).getStuName());
        //map.get() => Student가 나오는 거임






    }
}

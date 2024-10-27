import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 중간 연산 : filter(), map(), mapToInt()
// 최종 연산 : sum(), forEach(), collect(), count(), reduce(), [average(), min(), max()]

public class Stream_4 {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("황시목",50));
        list.add(new Student("한여진",80));
        list.add(new Student("최빛",70));
        list.add(new Student("서동재",20));
        list.add(new Student("강원철",100));

        // 스트림을 사용해서 list에 저장된 학생 중 이름이 3글자이상인 이상인 학생의 점수의 합을 출력
        int sumOfScore = list.stream()
                .filter(stu -> stu.getName().length()>=3)
                .mapToInt(stu->stu.getScore())
                .sum();

        System.out.println(sumOfScore);


        // 중간 연산의 결과로 나오는 데이터를 리스트 형태로 저장하는 최종 연산
        // 점수가 50 초과인 것만
        List<Student> s = list.stream().filter(stu->stu.getScore()>50)
                .collect(Collectors.toList());

    }
}

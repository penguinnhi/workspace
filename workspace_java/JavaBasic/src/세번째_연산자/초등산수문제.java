package 세번째_연산자;

//534자루의 연필을 30명의 학생들에게 똑같이 나누어주었을 때 학생당 몇 개씩 가질 수 있고, 최종적으로 몇 개가 남는지 구하는 코드
//빈 칸에 알맞는 코드를 작성하시오.

public class 초등산수문제 {
    public static void main(String[] args) {
        int pencils=534;
        int student=30;

        int pencilsPerStudent=(pencils/student);
        int pencilsLeft=(pencils%student);

        System.out.println("학생 한 명당 가지는 연필 수 = "+pencilsPerStudent);
        System.out.println("최종적으로 남는 연필 수 = "+pencilsLeft);

    }
}

package collection.list;

import java.util.ArrayList;
import java.util.List;

public class TestStudent_li {
    public static void main(String[] args) {

        List<Student_li> stdli=new ArrayList<>();

        Student_li stu;

        Student_li std1=new Student_li("yu",30,50,60); //생성자

        Student_li std2=new Student_li("kk",50,40,90);

        Student_li std3=new Student_li("hh",80,70,50);

        stdli.add(std1);
        stdli.add(std2);
        stdli.add(std3);


        System.out.println("모든 정보 출력");
        //모든정보 출력
        for (Student_li studentLi : stdli) {
            System.out.println(studentLi);
        }

        System.out.println("150이상 모든정보출력");
        //총점이 150점 이상인 학생의 모든 정보 출력
        for (Student_li studentLi : stdli) {
            if (studentLi.getTotalScore() >= 150) {
                System.out.println(studentLi);
            }
        }


        System.out.println("모든학생평균점수");
        //모든 학생에 대한 평균 점수 출력

        for (Student_li studentLi : stdli) {
            int avg = studentLi.getTotalScore() / 3;
            System.out.println(avg);
        }


        System.out.println();
        System.out.println(1);

        //총점이 1등인 학생의 모든 정보 *********************************************
        int max = 0;
        for (Student_li studentLi : stdli) {


            if (studentLi.getTotalScore() > max) {
                max = studentLi.getTotalScore();

                /*
            } else if (stdli.get(1).getTotalScore() > stdli.get(2).getTotalScore()) {
                max = stdli.get(1).getTotalScore();
            } else if (stdli.get(2).getTotalScore() > stdli.get(1).getTotalScore()) {
                max = stdli.get(2).getTotalScore();*/
            }

        }
        System.out.println(max);
        for (Student_li studentLi : stdli) {
            if (max == studentLi.getTotalScore()) {
                System.out.println(studentLi);
            }
        }










    }
}

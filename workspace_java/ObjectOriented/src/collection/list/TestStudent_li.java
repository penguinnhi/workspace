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

        System.out.println();
        System.out.println("150이상 모든정보출력");
        //총점이 150점 이상인 학생의 모든 정보 출력
        for (Student_li studentLi : stdli) {
            if (studentLi.getTotalScore() >= 150) {
                System.out.println(studentLi);
            }
        }

        System.out.println();
        System.out.println("모든학생평균점수");
        //모든 학생에 대한 평균 점수 출력(총점에 대한 평균)

        /*for (Student_li studentLi : stdli) {
            double avg = studentLi.getTotalScore() / 3.0;
            System.out.println(avg);
        }*/

        int sum=0;
        for (Student_li stuli : stdli){
            sum+=stuli.getTotalScore();
        }
        System.out.println((double)sum/stdli.size());



        System.out.println();
        System.out.println("총점1등정보");

        //총점이 1등인 학생의 모든 정보 *********************************************
        //리스트에서 총점이 1등인 학생의 순번을 먼저 알아야함

        int index=0;// 총점이 1등인 학생의 index 순번
        int max2=0;// 가장 높은 총점

        for (int i=0;i<stdli.size();i++){
            if (max2<stdli.get(i).getTotalScore()){
                max2=stdli.get(i).getTotalScore();
                index=i;//현재 가장 높은 점수를 가진 학생은 i번째에 있다 ***********
            }
        }
        System.out.println(stdli.get(index));



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

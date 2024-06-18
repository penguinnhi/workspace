package collection.list;

import java.util.ArrayList;
import java.util.List;

public class School { //학교클래스
    private List<StudyClass> studyC;

    public School(List<StudyClass> studyC){
        this.studyC=studyC;
    }

    public List<StudyClass> getStudyC() { //학급 목록
        return studyC;
    }


    public void teacherClassStudent(String teacher){ //매개변수로 담당교사명을 받아, 해당 담당교사가 맡고 있는 모든 반의 학생 정보를 출력

        for (int i=0;i<studyC.size();i++){
            if (teacher.equals(studyC.get(i).getTeacher())){
                studyC.get(i).printAllStudents();
            }
        }

    }

    public void classScore(){ //각 반별로 반별 평균 점수 및 전체 학급에 대한 평균 점수를 출력

        System.out.println("각 반별 평균점수");//각 반별 평균점수

        for (int i=0;i<studyC.size();i++){
            studyC.get(i).avgScore();
        }

        double result=0.0;
        System.out.println("전체 학급에 대한 평균점수");//전체 학급에 대한 평균점수
        for (int i=0;i<studyC.size();i++){
            result = studyC.get(i).avgScore()/studyC.size();
        }
        System.out.println(result);

    }

    /*public void allClassHighestStudent(){ //모든 반에서 최고 성적을 가진 학생의 이름과 점수를 출력
        for (SchoolStudent s:studyC.sss)
    }*/

    public double classAvg(String className){ //매개변수로 반 이름을 받아, 해당 반의 평균을 리턴하는 기능

        return 0;
    }


}

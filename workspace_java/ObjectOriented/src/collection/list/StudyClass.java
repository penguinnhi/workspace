package collection.list;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

public class StudyClass { //교실클래스

    private String className;
    private String teacher;
    private List<SchoolStudent> sss;

    public StudyClass(String className,String teacher,List<SchoolStudent> sss) {
        this.sss = sss;
        this.className=className;
        this.teacher=teacher;
    }

    public StudyClass(){

    }

    //생성자 --

    // 반 안에 있는 학생정보를 보고싶으시대


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public List<SchoolStudent> getSss() {
        return sss;
    }

    public void setSss(List<SchoolStudent> sss) {
        this.sss = sss;
    }


    //---------------------------

    public void printAllStudents(){ //해당 반의 모든 학생의 모든 정보를 출력하는 기능
        for (SchoolStudent s:sss){
            System.out.println(s);
        }
    }


    public double avgScore(){ //해당 반의 평균 성적을 리턴하는 기능
        int total=0;
        for (SchoolStudent s:sss){
            total+=s.getScore();
        }
        return (double) total/sss.size();
    }


    public SchoolStudent highestScoreStudent(){ //해당 반에서 최고 성적을 지닌 학생을 리턴하는 기능
        int max=0;
        int index=0;

        for (int i=0;i<sss.size();i++){
            if (sss.get(i).getScore()>max){
                max= sss.get(i).getScore();
                index++;
            }
        }
        return sss.get(index);

    }



}

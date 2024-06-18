package collection.list;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
    public static void main(String[] args) { //복잡도 하다
        //각 교실에 3명씩 학생을 생성한다.
        //1반 소속될 학생 3명
        SchoolStudent ss1=new SchoolStudent("김수한무",20,200);
        SchoolStudent ss2=new SchoolStudent("두루미",15,100);
        SchoolStudent ss3=new SchoolStudent("거북이",80,500);
        //1반에 소속될 학생 리스트 만들기
        List<SchoolStudent> sss=new ArrayList<>();

        sss.add(ss1);
        sss.add(ss2);
        sss.add(ss3);

        //1반
        StudyClass sClass1=new StudyClass("토끼반","토끼",sss);


        //2반
        SchoolStudent ss2_1=new SchoolStudent("너무",15,250);
        SchoolStudent ss2_2=new SchoolStudent("많은",50,300);
        SchoolStudent ss2_3=new SchoolStudent("학생",40,100);

        List<SchoolStudent> sss2=new ArrayList<>();

        sss2.add(ss2_1);
        sss2.add(ss2_2);
        sss2.add(ss2_3);

        StudyClass sClass2=new StudyClass("여우반","여우",sss2);

        //3반
        SchoolStudent ss3_1=new SchoolStudent("우유",20,200);
        SchoolStudent ss3_2=new SchoolStudent("딸기",30,300);
        SchoolStudent ss3_3=new SchoolStudent("초코",10,100);

        List<SchoolStudent> sss3=new ArrayList<>();

        sss3.add(ss3_1);
        sss3.add(ss3_2);
        sss3.add(ss3_3);

        StudyClass sClass3=new StudyClass("자라반","자라",sss3);

        //---------------------------

        //교실을 여러개 저장할 수 있는 리스트 생성
        List<StudyClass> studyC=new ArrayList<>();

        School school=new School(studyC);

        studyC.add(sClass1);
        studyC.add(sClass2);
        studyC.add(sClass3);

        //학교안의 모든학생 정보 출력 ..
        // 학교 안에 교실 안에 학생이 있어요 ,,,,,,,,,,,,,,,교실에 먼저 접근을 해야해요,,,,,,
        //학교 안에 있는 교실 수만큼 반복

        for (int i=0;i<school.getStudyC().size();i++){
            school.getStudyC().get(i);
            //학교안에있는.학급목록안에있는.학생.
            for (int e=0;e<school.getStudyC().get(i).getSss().size();e++){
                //학교안에있는.학급목록안에 있는 교실. / 학생목록 / i반에있는 학생 수만큼 반복
                sss.get(e);
            }
        }


        sClass1.printAllStudents();
        System.out.println(sClass1.avgScore());
        System.out.println(sClass1.highestScoreStudent());



        //school.teacherClassStudent("자라");
        //school.classScore();

    }
}

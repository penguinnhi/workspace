package com.green.ListPractice.service;

import com.green.ListPractice.vo.StudentVO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

//학생관리 프로그램의 핵심 기능을 정의 <- model 이라고 함
//m v c : model view control
public class StudentService {
    //학생 여럿 넣을 통
    List<StudentVO> stuList=new ArrayList<>();

    //학생 목록 조회

    public List<StudentVO> getStuList(){
        return stuList;
    }

    //학생 등록

    public void regStudent(StudentVO studentVO){
        stuList.add(studentVO);
    }

    //학생 상세 조회

    public StudentVO getStuDetail(StudentVO studentVO,int detail){

        /*StudentVO result=null;
        for (int i=0;i<stuList.size();i++){
            if (stuList.get(i).getName().equals(detail)){
                result=stuList.get(i);
            }
        }*/ //이건 학생 이름으로 찾는거

        StudentVO result=null;
        for (int i=0;i<stuList.size();i++){
            if (stuList.get(i).getStuNum()==detail){
                result=stuList.get(i);
            }
        }

        /*
        StudentVO findStudent=null; //학번이 일치하는 학생을 저장할 공간을 만드는거다~
        for (StudentVO student : stuList){
            if (student.getStuNum()==detail){
                findStudent=student;
            }
        }
*/
        return result;
    }

    //학생 삭제

    public void delStu(int detail){

       /* StudentVO result=null;
        for (int i=0;i<stuList.size();i++){
            if (stuList.get(i).getStuNum()==detail){
                result = stuList.remove(i);
            }
        }*/

        //삭제를 위해서는 삭제할 학생의 index 번호 필요
        //index를 알기위해서는 학번데이터가 필요
        int index=0;
        for (int i=0;i<stuList.size();i++){
            if (stuList.get(i).getStuNum()==detail){
                index=i;
            }
        }
        stuList.remove(index);

       // return result;

    }

    //학생 정보 수정

    public void updateStu(StudentVO studentVO){ //****************
        //리스트에서 정보를 수정하고자 하는 학생을 찾아
        // 그 학생의 정보를 input태그 및 textarea에서 입력한 정보로 변경한다
        //는 코드를 만들라..
        for (StudentVO student:stuList){
            if (student.getStuNum()==studentVO.getStuNum()){ //?******************
                //student는 저장한 학생들/ studentVO는 매개변수로 들어온 학생
                student.setName(studentVO.getName());
                student.setKorScore(studentVO.getKorScore());
                student.setEngScore(studentVO.getEngScore());
                student.setIntroduce(studentVO.getIntroduce());
            }
        }

    }


  /*  public StudentVO updateStu(StudentVO studentVO,int detail){

        StudentVO result=null;
        for (int i=0;i<stuList.size();i++){
            if (stuList.get(i).getStuNum()==detail){
                result=stuList.get(i);

            }
        }

        return result;


    }*/


}

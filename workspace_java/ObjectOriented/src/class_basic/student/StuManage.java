package class_basic.student;

//학생관리 클래스

import class_basic.man.Student;

import java.util.Scanner;

public class StuManage {
    private Scanner sc; //자동초기화 null. 키보드 입력을 위해 선언
    private Stu[] students; //학생 다수를 저장하라 배열
    private int idx;//학생 배열의 요소

    public StuManage(){
        sc=new Scanner(System.in);
        students=new Stu[3];
        idx=0;
    }


    public void regStu(){
        if (idx>=3){
            System.out.println("더이상 학생을 추가할 수 없습니다.");
        }
        else {
            System.out.println("학생 등록을 시작합니다. 학생 정보를 입력하세요.");
            System.out.print("이름 : ");
            String name=sc.next();

            System.out.print("나이 : ");
            int age=sc.nextInt();

            System.out.print("연락처 : ");
            String tel=sc.next();

            System.out.print("학점 : ");
            String grade=sc.next();

            // 입력받은 정보로 학생 객체 생성
            Stu stu=new Stu(name,age,grade,tel);

            // 생성한 학생 객체를 배열에 저장
            students[idx]=stu;
            idx++;

        }

    }//학생 등록 메서드.




    public void changeInfo(){
        System.out.println("학생의 연락처를 변경합니다.");

        for (int i=0;i<idx;i++){

            System.out.print("변경 학생 : ");
            String name=sc.next();

            if (students[i].getName().equals(name)) {

                System.out.print("변경할 연락처 : ");
                String tel=sc.next();
                students[i].setTel(tel);

                System.out.println("변경 완료 되었습니다.");

                break;
            }

            else {
                System.out.println("해당하는 학생이 존재하지 않습니다. 다시 입력하세요.");

            }
        }

    }//정보변경 연락처 메서드



    public void printStu(){

        System.out.print("입력 : ");
        String name=sc.next();

        System.out.println();
        System.out.println("정보를 열람할 학생 : "+name);

        for (int i=0;i<idx;i++){


            if (students[i].getName().equals(name)){

                System.out.println("요청하신 학생의 정보입니다.");
                students[i].showInfo();
                break;
            }

            else {
                System.out.println("정보를 열람할 학생 : "+name);
                System.out.println("해당하는 학생이 존재하지 않습니다. 다시 입력하세요.");
            }
        }


    }//학생정보출력 메서드



    public void printAll(){
        for (int i=0;i<idx;i++){
            students[i].showInfo();
        }//for each는 idx만큼이 아니라 전체배열을 다 돌아서 안됨

        System.out.println("모든 학생의 정보입니다. 현재 총 학생 수는 "+idx+"명 입니다.");


    }//모든학생정보출력 메서드


}


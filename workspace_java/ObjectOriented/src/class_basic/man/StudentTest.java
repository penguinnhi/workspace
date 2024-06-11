package class_basic.man;


import java.security.PublicKey;
import java.sql.SQLOutput;

//배열+클래스
public class StudentTest {
    public static void main(String[] args) {
        //학생을 5명 저장할 수 있는 배열 생성
        Student[] students=new Student[5];

        //여러분 제가 누군지는 알아요?

        Student s1=new Student("김수한무",20,100);
        Student s2=new Student("두루미와",30,200);
        Student s3=new Student("거북이",15,150);
        Student s4=new Student("삼천갑자",35,300);
        Student s5=new Student("동방삭",50,210);

        students[0]=s1;
        students[1]=s2;
        students[2]=s3;
        students[3]=s4;
        students[4]=s5;

        //1.배열에 저장된 모든 학생의 이름,나이,점수를 출력

        /*for (int i=0;i<students.length;i++){
            students[i].printStudent();
            System.out.println();
        }
*/

        //1번문제를 for each문으로 해결
        /*for (Student i:students){
            i.printStudent();
            System.out.println();
        }*///i=s1,s2,s3,s4,s5다 저런



        //2.배열에 저장된 학생 중 점수가 80점 이상인 학생의 이름,나이,점수 출력
        /*for (int i=0;i<students.length;i++){
            if (students[i].getScore()>=180){
                students[i].printStudent();
                System.out.println();
            }
            else {
                System.out.println("저런");
                System.out.println();
            }
        }*/

        //3. 이름이'김수한무'인 학생을 찾아 해당 학생의 나이를 10으로 변경
        for (int i=0;i<students.length;i++){
            if (students[i].getName().equals("김수한무")){
                students[i].setAge(10);
            }
        }//students[i]=Student
        s1.printStudent();


        for (Student i:students){
            if (i.getName().equals("김수한무")){
                i.setAge(10);
            }
        }//i=Student
        s1.printStudent();


    }
}

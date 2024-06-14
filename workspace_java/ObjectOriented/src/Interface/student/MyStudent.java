package Interface.student;

public class MyStudent implements StudentUtil {


    @Override
    public String getGradeByStudentName(Student[] students, String name) {

        String grade="등급없음";
        //*************************************************sum에 0주듯이 String 어쩌구=""; 이렇게 공백주기

        for (Student stu:students){//****************

            if (stu.getName().equals(name)){

                double avg= (stu.getKorScore()+stu.getEngScore()+stu.getMathScore())/3.0;
                grade=getGradeByAvg(avg);//*************

                /*if(avg>=90&&avg<=100){
                    Grade="A";
                }
                else if(avg>=80&&avg<90){
                    Grade="B";
                }
                else if(avg>=70&&avg<80){
                    Grade="C";
                }
                else if(avg<70){
                    Grade="D";
                }*/

            }

        }

        return grade;
    }

    //점수에 따라 등급을 결정하는 메서드
    public String getGradeByAvg(double avg){
        String grade="등급없음";

        if(avg>=90&&avg<=100){
            grade="A";
        }
        else if(avg>=80){
            grade="B";
        }
        else if(avg>=70){
            grade="C";
        }
        else if(avg<70){
            grade="D";
        }

        return grade;
    }



    @Override
    public int[] getTotalScoresToArray(Student[] students) {//*************??
        //학생들의 총점이 저장될 배열
        int[] totalScores =new int[students.length];

        /*for (Student stu:students){
            for (int i=0;i<totalScores.length;i++){
                totalScores[i]=stu.getKorScore()+stu.getEngScore()+stu.getMathScore();
            }
        }*/


        for (int i=0;i<students.length;i++){ // 학생 한 명 한 명의 총점
            totalScores[i]=students[i].getKorScore()+students[i].getEngScore()+students[i].getMathScore();
        }

        return totalScores;//**?

    }



    @Override
    public Student getHighScoreStudent(Student stu1, Student stu2) {

        int total1=stu1.getEngScore()+stu1.getMathScore()+stu1.getKorScore();
        int total2=stu2.getEngScore()+stu2.getMathScore()+stu2.getKorScore();

        /*if (total1>total2){
            return stu1;
        }
        else {
            return stu2;
        }*/

        return total1>total2?stu1:stu2;

    }

   /* public int getTotal(){
        return  ;
    }*/












//---------------------------------------------

    /*public String getGradeByStudentName(String name){


        for (int i=0;i<idx;i++){



            students[idx]=;

            if (name.equals(stu.getName())){

                if(avg>=90&&avg<=100){
                    setGrade("A")
                 }
                 else if(avg>=80&&avg<90){
                     setGrade("B")
              }
                else if(avg>=70&&avg<80){
                     setGrade("C")
               }
                 else if(avg<70){
                     setGrade("D")
                 }

                idx++;

            }


            else{
                setGrade("등급없음")

            }

        }

    }*/





}

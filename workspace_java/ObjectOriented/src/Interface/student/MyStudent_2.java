package Interface.student;

public class MyStudent_2 implements StudentUtil{



    @Override
    public String getGradeByStudentName(Student[] students, String name) {

        String grade="";

        for(Student stu:students) {
            if (stu.getName().equals(name)) {
                double avg = (stu.getEngScore() + stu.getKorScore() + stu.getMathScore()) / 3.0;
                grade = getGrade(avg);
            }
        }
        return "";
    }

    public String getGrade(double avg){
        if (avg>=90&&avg<=100){
            return "A";
        }
        else if (avg>=80){
            return "B";
        }
        else if (avg>=70){
            return "C";
        }
        else if (avg<70){
            return "D";
        }
        else {
            return "등급없음";
        }
    }

    @Override
    public int[] getTotalScoresToArray(Student[] students) {

        int[] totalArr=new int[students.length];

        for (int i=0;i< students.length;i++){
            totalArr[i]=students[i].getEngScore()+students[i].getMathScore()+students[i].getKorScore();

        }

        return totalArr;
    }


    @Override
    public Student getHighScoreStudent(Student stu1, Student stu2) {
        int total1=stu1.getEngScore()+stu1.getKorScore()+stu1.getMathScore();
        int total2=stu2.getEngScore()+stu2.getMathScore()+stu2.getKorScore();

        if (total1>total2){
            return stu1;
        }
        else{
            return stu2;
        }

        //return total1>total2?stu1:stu2;

        //근데 이 맥스는 점수야 점수로 인간을 어떻게 구해?

    }



}

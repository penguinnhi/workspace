package Interface.student;


import java.util.Arrays;

public class MyStuTest {
    public static void main(String[] args) {

        MyStudent mst=new MyStudent();

        Student s1=new Student("ㅇㄹ",80,80,80);
        Student s2=new Student("ㄱㄹ",10,70,60);
        Student s3=new Student("ㅇㅁㅁ",50,40,10);
        Student s4=new Student("ㅇㅁㄱ",30,20,50);
        Student s5=new Student("ㅇㅇㄹㄷ",70,10,40);

        Student[] students=new Student[5];
        students[0]=s1;
        students[1]=s2;
        students[2]=s3;
        students[3]=s4;
        students[4]=s5;

        System.out.println(mst.getGradeByStudentName(students,"ㅇㄹ"));
        String result1 = mst.getGradeByStudentName(students,"ㅇㄹ");
        System.out.println(result1);

        int[] result2 = mst.getTotalScoresToArray(students);
        System.out.println(Arrays.toString(result2));//*************

        Student stu = mst.getHighScoreStudent(s1,s3);
        System.out.println(stu.getName());


    }

}

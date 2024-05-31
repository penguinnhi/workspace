package If_문제_1;

public class Test5 {
    public static void main(String[] args) {
        int a=50;
        String grade="";


        if (a>90&&a<=100){
            grade="A";
            ;
        }
        else if (a>80){
            grade="B";
            ;
        }
        else{
            grade="C";
            ;
        }
        System.out.println("학점은 "+grade);
    }
}

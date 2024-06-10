package class_basic;

public class Student { //Student를 만들 거라고 정의

    String name;
    int age;
    int score;

    //매개변수로 전달된 문자열로 name 값을 변경
    public void setName(String name1){
        name=name1;
    }

    //메서드의 호출부분은 다른 메서드로 갈 수 없다? ? ? ? ?

    //나이를 변경하는 메서드
    public void setAge(int age1){
        if (age1<0){
            age=0;
        }
        else {
            age=age1;
        }
    }




    public void introduce(){


        System.out.println("이름은 "+name);
        System.out.println("나이는 "+age);
        System.out.println("점수는 "+score);
    }

}

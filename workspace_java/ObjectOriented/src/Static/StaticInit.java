package Static;

//static 키워드가 붙은 멤버변수의 초기화 방법
//static 키워드가 붙은 멤버변수는 생성자에서 초기화 X
//초기화 구문이 따로 존재
public class StaticInit {
    int a;
    static int num; //class 안에 있다고 보기는 어렵다

    //static변수 초기화
    static{
        num=5;
    }

    public StaticInit(){
        a=10;
        //num=5; 생성자에서 static 초기화 X
        num++;
        System.out.println("a:"+a);
        System.out.println("num:"+num);
    }

}

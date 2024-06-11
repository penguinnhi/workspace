package class_basic.test1_16;

public class Rectangle {
    private int x1;
    private int y1;// 이 두개가 하나의 직사각형
    private int x2;
    private int y2; // 이 두개가 하나의 직사각형
    //필드 = 멤버변수

    public Rectangle(){
    }//디폴트생성자

    public Rectangle(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }//값을 설정하는 생성자


    public void set(int x1,int y1,int x2,int y2){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }//좌표 설정


    public int square(){
        return (x2-x1) * (y2-y1);
    }//사각형의 넓이 리턴 수학이네

    public void show(){
        System.out.println("("+x1+","+y1+")"+", ("+x2+","+y2+")"); //좌표
        System.out.println("사각형의 넓이 : "+square()); //넓이

    }//좌표와 넓이 등 직사각형 정보의 화면 출력

    public boolean equals(Rectangle r){
        if (r.square()==square()){
            return true;
        }
        else {
            return false;
        }
    }//인자로 전달된 객체 r과 현 객체가 같은 넓이라면 직사각형이면 true 리턴 ****************ㅁㄹ


}

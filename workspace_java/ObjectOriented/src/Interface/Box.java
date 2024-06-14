package Interface;

//무엇이든 (모든 '클래스' 자료형을 = Object 클래스 // 기본자료형 원칙상 안됨 ) 넣고 뺄 수 있는 만능 박스
//기본자료형 넣을 수 있는 클래스가 Wrapping 클래스

public class Box {
    Object str;

    public void setBox(Object str){
        this.str=str;
    }

    public Object getBox(){
        return str;
    }



}

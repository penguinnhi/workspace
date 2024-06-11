package class_basic.Value;


public class Add {

    private int a;
    private int b;

    public Add(){
    }

    public void setValue(int a,int b){
        this.a=a;
        this.b=b;
    }//피연산자를 객체 내에 설정한다

    public int calculate(){
        return a+b;
    }

}

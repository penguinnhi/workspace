package class_basic.calculator;

public class Calculator {

    private int a;
    private int b;


    public void setNumber(int a,int b){
        this.a=a;
        this.b=b;
    }

    public int getAdd(){
        return a+b;
    }

    public int getSub(){
        return a-b;
    }

    public int getMul(){
        return a*b;
    }

    public double getDiv(){
        return (double)a/b;
    }




}

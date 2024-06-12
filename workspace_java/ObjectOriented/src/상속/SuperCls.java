package 상속;

public class SuperCls {

    public SuperCls(int a){
    }
    /*public SuperCls(){

    }*/
    public SuperCls(String a,int b){

    }

}

class SubCls extends SuperCls{
    public SubCls(){
        super("d",2);
    }

}

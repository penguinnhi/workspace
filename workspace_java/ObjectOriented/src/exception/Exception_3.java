package exception;


//예외 전가
public class Exception_3 {
    public static void main(String[] args) {
        try {
            bbb();
        }catch (Exception e){

        }


    }

    public static void aaa() throws Exception {//예외 전가

        System.out.println(5/0);//예외가 발생할 수 있는 곳에서 예외처리 해줘야함

    }

    public static void bbb() throws Exception{
        aaa();
    }
}

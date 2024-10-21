

public class OuterTest {
    public static void main(String[] args) {
        // Outer 클래스에 대한 객체 생성
        Outer outer=new Outer();

        // Board 클래스의 객체 생성
        Outer.Board board = outer.new Board();

        // 요새 안씀 그냥 클래스안에 클래스가 있을 수 있다라는 거만 알아두기

    }

}

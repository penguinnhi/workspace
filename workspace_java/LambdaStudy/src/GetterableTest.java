public class GetterableTest {
    public static void main(String[] args) {

        class Test implements Getterable{

            @Override
            public void getNum() {

            }

        }

        Test t=new Test();
        t.getNum();



        Getterable g= ()-> { System.out.println(10);};
        g.getNum();

        // 람다로 구현한 메서드의 내용 부분이 한 줄이라면 {} 생략가능
        Getterable g1=()-> System.out.println(10);

    }
}



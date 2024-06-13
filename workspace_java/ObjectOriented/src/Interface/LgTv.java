package Interface;


public class LgTv implements Tv{


    @Override
    public void turnOn() {
        System.out.println("엘지티비 켬");
    }

    @Override
    public void turnOff() {
        System.out.println("엘지티비 끔");
    }

    @Override
    public void soundUp() {
        System.out.println("엘지티비 소리업");
    }

    @Override
    public void soundDown() {
        System.out.println("엘지티비 소리다운");
    }
}

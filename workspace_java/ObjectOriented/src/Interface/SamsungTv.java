package Interface;

public class SamsungTv implements Tv {


    @Override
    public void turnOn() {
        System.out.println("삼성티비-전원켬");
    }

    @Override
    public void turnOff() {
        System.out.println("삼성티비-전원끔");
    }

    @Override
    public void soundUp() {
        System.out.println("삼성티비-소리올림");
    }

    @Override
    public void soundDown() {
        System.out.println("삼성티비-소리내림");
    }


}

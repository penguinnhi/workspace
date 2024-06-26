public class Restaurant {
    private Chef chef;

    public Restaurant(){
        chef=new Chef();
    }

    public void service(){
        System.out.println("짜라짜라짜 짜 파게티 농심 짜파게티");
        chef.makeCook();
    }

}

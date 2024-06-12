package 상속;

public class Animal_2 {
    public static void main(String[] args) {

        Animal[] animalH=new Animal[10];
        Animal d1=new Dog();
        Animal cat1=new Cat();
        Animal cow1=new Cow();

        animalH[0]=d1;
        animalH[1]=cat1;
        animalH[2]=cow1;

        //Animal클래스의 변수,메서드 사용가능
        //Dog클래스의 변수,메서드 사용불가
        animalH[0].bark();
        //animalH[0].aaa();


        for (int i=0;i<3;i++){
            animalH[i].bark();
        }


    }
}

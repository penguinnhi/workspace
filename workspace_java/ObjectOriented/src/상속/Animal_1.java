package 상속;

public class Animal_1 {
    public static void main(String[] args) {

        Dog[] dogH=new Dog[5];
        Cat[] catH=new Cat[5];
        Cow[] cowH=new Cow[5];

        Dog dog1=new Dog();
        dogH[0]=dog1;
        Dog dog2=new Dog();
        dogH[1]=dog2;
        Dog dog3=new Dog();
        dogH[2]=dog3;

        Cat cat1=new Cat();
        catH[0]=cat1;
        Cat cat2=new Cat();
        catH[1]=cat2;

        Cow cow1=new Cow();
        cowH[0]=cow1;

        for (int i=0;i<3;i++){
            dogH[i].bark();
        }
/*
        for (int i=0;i<2;i++){
            catH[i].barkCat();
        }

        for (int i=0;i<1;i++){
            cowH[i].barkCow();
        }*/


    }
}

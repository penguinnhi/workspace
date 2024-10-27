package basic;

// 클래스가 제네릭이 아닌 클래스 안의 특정 메서드만 제네릭화 시키기
public class GenericMethod {
    public static void aaa(){
        System.out.println("11");
    }

    // 매개변수로 데이터가 전달됨. 그 데이터는 자료형이 정해지지 않음
    // 이러한 매개변수를 전달받아, 박스에 저장하고
    // 데이터가 저장된 박스를 리턴하는 메서드
    // static : 객체 생성 없이 바로 부르기 가능
    public static <T>Box<T> makeBox(T data){
        // 제네릭타입임을 알리는 <T> , 리턴타입이 Box<T>
        Box<T> box=new Box<T>();
        box.setData(data);
        return box;

    }

    // 매개변수로 Box<String> 전달 가능? ㅇㅇ
    public static <T> void peekBox(Box<T> box){
        System.out.println(box);
    }

    // 제네릭 메서드다? ㄴㄴ
    // 와일드 카드 문법 - 위의 peekBox 메서드와 완전 동일
    // 가정 : 매개변수에 Box<Phone> 전달
    public static void peekBox1(Box<?> box){
        box.getData();
        System.out.println(box);
    }



    // 와일드 카드의 상한제한, 하한제한 (제네릭 문법의 타입인자 제한과 비슷)
    // 와일드 카드의 상한제한
    // ?에 들어오는 자료형을 제한
    // Phone 클래스 혹은 Phone 클래스를 상속한 클래스만 들어올 수 있음
    public static void peekBox3(Box<? extends Phone> box){
        System.out.println(box);
    }

    // 와일드 카드의 하한제한
    // Phone 클래스이거나 Phone 클래스의 상위 클래스만 들어올 수 있음
    public static void peekBox4(Box<? super Phone> box){
        System.out.println(box);
    }



    //상한제한 사용 이유
    // 사용하지 않았을 시 문제점
    // outBox 에서는 매개변수로 전달된 장난감이 들어있는 박스에서 장난감을 꺼내는 기능
    // 상한 제한을 하면 메서드 안에서 데이터를 저장하는 코드 사용을 막을 수 있음
    public static void outBox(Box<Toy> box){
        Toy toy = box.getData();
        box.setData(new Toy());
    }

    public static void outBox1(Box<? extends Toy> box){
        Toy toy = box.getData();
//        box.setData(new Toy()); 안되는걸 미리 알려줌 : 오류
    }





    // 매개변수로 박스와 박스에 담을 객체 전달
    // 전달받은 박스에 전달받은 객체를 저장
    public static void inBox(Box<Toy> box, Toy toy){
        box.setData(toy);
        Toy t = box.getData(); // Box<Toy>를 하한제한으로 바꾸면 빨간줄 생김
    }

    // 하한제한을 걸면 데이터 빼오는 것을 막는 것
    public static void inBox1(Box<? super Toy> box, Toy toy){
        box.setData(toy); // Box<Toy>, Box<Object>
//        Toy t = box.getData(); // Box<Toy>를 하한제한으로 바꾸면 빨간줄 생김 : 오류

    }




    //상한, 하한제한 사용의 적절한 예시
    //매개변수로 두 개의 상자가 전달되고 하나의 상자의 데이터를 다른 하나의 상자에 옮기는 기능
    public static void moveBox(Box<Toy> toBox,Box<Toy> fromBox){
        //fromBox->toBox
        toBox.setData(fromBox.getData());

        fromBox.setData(toBox.getData()); //개발자의 실수
    }

    public static void moveBox1(Box<? super Toy> toBox,Box<? extends Toy> fromBox){
        //fromBox->toBox
        toBox.setData(fromBox.getData());

//        fromBox.setData(toBox.getData()); 개발자의 실수
    }

    // 와일드 카드의 최초 목적 : 여러 자료형을 전달받기 위해
    // 코드의 안정성 향상을 위해 상한,하한제한 도입 : 최초 목적을 상실
    // 이 문제를 해결하기 위해 제네릭과 와일드 카드를 동시에 사용
    public <T> void finalOutBox(Box<? extends T> box){

    }



    // 제네릭 메서드이다? ㄴㄴ
    // 매개변수로 Box<String> 전달 가능? ㄴㄴ
    public static void peekBox2(Box<Object> box){
        System.out.println(box);
    }


}

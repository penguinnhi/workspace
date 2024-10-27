public interface LambdaPractice { // 구현할 메서드가 하나뿐이면 함수형 인터페이스

    void printName();
}


interface LambdaPractice1 {

    void printName(String name);
}

interface LambdaPractice2 {

    void printMyInfo(String name,int age);
}

interface LambdaPractice3 {

    int getData();
}

interface LambdaPractice4 {

    int getResult(int a, int b);
}

// 계산기
interface LambdaPractice5 {
    int getResult(int a, int b);
}


// --1022

// 람다식을 쓰기 위한 인터페이스
// 제네릭 활용
@FunctionalInterface
interface LambdaPractice6<T> {
    T getResult(T a, T b);
//    void aaa();
}

@FunctionalInterface
interface LambdaPractice7<T,R> {
    R getResult(T a, T b);
}




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


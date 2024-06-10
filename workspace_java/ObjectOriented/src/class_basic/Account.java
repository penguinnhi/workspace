package class_basic;

//좋은 클래스의 여건
//1.멤버변수는 반드시 초기값을 설정
//2.초기값 설정은 멤버변수의 선언과는 별도로 진행

public class Account {
    //계좌

    String accNumber;
    String owner;
    int money; //예금액

    //생성자(변수의 초기화), 객체생성할 때 한 번 호출되고 그 후로는 호출 안됨 ******************
    //문법
    /*
    * public 클래스명(){

           }
    * */
    //클래스 안에는 반드시 생성자가 존재해야함 / 객체를 만드는 문법에 생성자가 포함되어 있기 때문에
    // 아 화장실가고싶다
    // 만약 클래스 안에 생성자를 하나도 선언하지 않았다면 눈에 보이지않는
    // 기본 생성자를 자동으로 만들어줌 (노내용 노매개변수 생성자)
    // 생성자는 여러개 만들기 가능


    public Account(){//클래스명이랑 똑같이
        accNumber="미정";
        owner="미정";
        money=10000;
    }

    public Account(int a){
        money=a;
    }


    //모든 변수의 값을 변경하는 메서드를 만들기
    public void setAccount(String accNumber,String owner,int money){
        //this : 이 클래스에서 선언한 accNumber***********
        this.accNumber=accNumber;
        this.owner=owner;
        this.money=money;
    }

    public void printAccount(){
        System.out.println("계좌번호 : "+accNumber);//
        System.out.println("계좌주 : "+owner);
        System.out.println("예금액 : "+money);
    }




}

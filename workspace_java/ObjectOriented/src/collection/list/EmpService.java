package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService extends Worker_li {
    Scanner sc=new Scanner(System.in);

    public EmpService(int workerNum, String name, String officeName, String tel, String pay) {
        super(workerNum, name, officeName, tel, pay);
        if (workerNum || tel){
            System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
        }
    }


    public void logIn() {
        System.out.print("사번 : ");
        getWorkerNum();
        System.out.print("비밀번호(연락처의 마지막 4자리) : ");
        getTel();



        System.out.println("로그인 하였습니다");
        System.out.println("'"+?.get(i).getName()+"'님 반갑습니다");

    }

    public void printPay(){
        int totalPay=;
        double avgPay=;

        System.out.print("부서명");
        String on = sc.next();

        if (on.equals("개발부")){
            System.out.println("개발부 월급 현황");


            System.out.println("개발부서의 월급 총액은"+);
        }

    }


    public void printAllPay(){


    }



}

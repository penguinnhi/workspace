package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
    private List<Worker_li> empList;
    private Scanner sc;


    public EmpService() {

        sc=new Scanner(System.in);
        empList=new ArrayList<>();

        Worker_li w1=new Worker_li(1001,"홍길동","개발부","1111-1234",1000);
        Worker_li w2=new Worker_li(1002,"김길동","개발부","1111-1112",2000);
        Worker_li w3=new Worker_li(1003,"최길동","인사부","1111-1113",4000);
        Worker_li w4=new Worker_li(1004,"우길동","영업부","1111-1113",3000);
        Worker_li w5=new Worker_li(1005,"와길동","영업부","1111-1113",5000);

        empList.add(w1);
        empList.add(w2);
        empList.add(w3);
        empList.add(w4);
        empList.add(w5);

    }


    //1.
    public void logIn() {
        boolean isRunning=true;//while문 반복 변수 ****************
        boolean isFind=false;//?????????????

        while (isRunning) {

            System.out.print("사번 : ");
            int woNo=sc.nextInt();
            System.out.print("비밀번호(연락처의 마지막 4자리) : ");
            String pw=sc.next();

            for (Worker_li w:empList) {
                if (woNo == w.getWorkerNum() && pw.equals(w.getPw())) {
                    isRunning = false;//while문 벗어남 *****************

                    System.out.println("로그인하였습니다");
                    System.out.println("'" + w.getName() + "'님 반갑습니다.");

                    isFind=true; // ?? ********** ?????????????????
                }
            }

           if (!isFind) {//??????????????? ????? ?????????? 노이해
               // if문은 true일때 실행함 > 우리는 못찾았을 때 실행해야해서 > ! : 부정연산자 < 붙임

               System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");

           }

        }

    }



    //2.
    public void printDeptPay(){
        int total=0;
        double avg=0;
        int cnt=0;

        System.out.print("부서명 : ");
        String dept = sc.next();

        System.out.println();
        System.out.println(dept+" 월급 현황");
        for (int i=0;i<empList.size();i++) {

            if (empList.get(i).getdept().equals(dept)) {
                System.out.print(empList.get(i)); //입력받은 부서의 월급정보
                System.out.println();

                total+=empList.get(i).getPay(); // 월급총액
                cnt++; //******* 해당하는 사원 수 세는거

                avg=(double)total/cnt;

            }

        }

        System.out.println(dept+"서의 월급 총액은 " + total + "원이며, 평균 급여는 " + avg + "원입니다.");

    }

    //3.
    public void printAllPayUp(){
        System.out.print("부서명 : ");
        String dept=sc.next();
        System.out.print("인상급여 : ");
        int pay=sc.nextInt();

        System.out.println(dept+ " 각 사원의 급여가 각각 "+pay+"원씩 인상됩니다.");
        System.out.println("=월급 인상 후 "+dept+" 월급 현황");

        //급여 인상 코드 작성
        for (Worker_li w:empList) {
            if (dept.equals(w.getdept())) {
                int result=w.getPay()+pay; //사원의 원래월급 + 인상금액
                w.setPay(result);
            }
        }

        //인상된(=내가 입력한) 사원 정보 출력
        for (Worker_li w:empList){
            if (dept.equals(w.getdept())) {
                System.out.println(w);
            }
        }

   }



}

package collection.list;

import java.util.ArrayList;
import java.util.List;

public class TestMember_li {
    public static void main(String[] args) {

        /*Member_li ml1=new Member_li();
        Member_li ml2=new Member_li();
        Member_li ml3=new Member_li();*/

        //멤버객체를 저장할 수 있는 리스트 객체 생성
        List<Member_li> memli=new ArrayList<>(); //통 됨

        //3개 저장
        Member_li ml1=new Member_li("yu","123","유",32); //생성자
        Member_li ml2=new Member_li("kk","852","강",25);
        Member_li ml3=new Member_li();//set으로 만들어도 됨


        ml3.setId("java");
        ml3.setPw("963");
        ml3.setAge(41);
        ml3.setName("히히");

        /*for (Member_li ml:memli){
            memli.add(ml);
        }*/
        /*for (int i=0;i<3;i++){
            memli.add(memli.get(i));
        }*/

        memli.add(ml1);
        memli.add(ml2);
        memli.add(ml3);


        System.out.println("모두 출력");
        //모두 출력
        for (Member_li memberLi : memli) {
            System.out.println(memberLi);
        }



        System.out.println("나이 합 출력");
        //나이 합 출력
        int ageSum=0;
        for (int i=0;i<memli.size();i++){
            ageSum+=memli.get(i).getAge();//********
        }
        System.out.println(ageSum);

        //memli.get(i) == Member li *****************


        System.out.println("지워");
        //지우는
        int idx=0;//**************** 몇번째인지 확인하는 용도
        for (int i=0;i<memli.size();i++){
            if (memli.get(i).getId().equals("java")){
                idx=i;

            }
        }
        memli.remove(memli.get(idx));///****



    }
}

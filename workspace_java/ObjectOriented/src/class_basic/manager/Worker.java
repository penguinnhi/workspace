package class_basic.manager;

public class Worker {

    PersonInfo pi=new PersonInfo();
    WorkerInfo wi=new WorkerInfo();

    public Worker(){

    }
    public void setInfo(String name,int age,String address){
        pi.setName(name);
        pi.setAge(age);
        pi.setAddress(address);
    }

    public void setWorkerInfo(String companyName,String officeName,int pay){
        wi.setCompanyName(companyName);
        wi.setOfficeName(officeName);
        wi.setPay(pay);
    }


    public void displayWorker(){
        System.out.println("이름 : "+pi.getName());
        System.out.println("나이 : "+pi.getAge());
        System.out.println("주소 : "+pi.getAddress());

        System.out.println("회사명 : "+wi.getCompanyName());
        System.out.println("부서 : "+wi.getOfficeName());
        System.out.println("급여 : "+wi.getPay());
    }



}

package collection.list;

public class Worker_li {
    private int workerNum;
    private String name;
    private String dept;
    private String tel;
    private int pay;

    public Worker_li(int workerNum, String name, String dept, String tel, int pay) {
        this.workerNum = workerNum;
        this.name = name;
        this.dept = dept;
        this.tel = tel;
        this.pay = pay;
    }

    public int getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(int workerNum) {
        this.workerNum = workerNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdept() {
        return dept;
    }

    public void setdept(String dept) {
        this.dept = dept;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getPw(){

        return this.tel.substring(5);

    }



    @Override
    public String toString() {
        return "Worker_li{" +
                " name='" + name + '\'' +
                ", pay='" + pay + '\'' +
                '}';
    }

}

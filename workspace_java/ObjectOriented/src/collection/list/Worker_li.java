package collection.list;

public class Worker_li {
    int workerNum;
    private String name;
    private String officeName;
    private String tel;
    private String pay;

    public Worker_li(int workerNum, String name, String officeName, String tel, String pay) {
        this.workerNum = workerNum;
        this.name = name;
        this.officeName = officeName;
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

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Worker_li{" +
                "workerNum=" + workerNum +
                ", name='" + name + '\'' +
                ", officeName='" + officeName + '\'' +
                ", tel='" + tel + '\'' +
                ", pay='" + pay + '\'' +
                '}';
    }
}

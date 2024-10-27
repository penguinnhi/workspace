import jdk.jfr.Frequency;

public class Friends {
    private String name;
    private Company company;

    public Friends(String name, Company company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    // 친구가 다니는 회사의 주소 정보를 출력하는 메서드
    public void printCompanyAddress(){
        String addr=getCompany().getContactInfo().getAddr();
        System.out.println(addr);


        String addr1=null;

        Company company1 =getCompany();

        if (company1!=null){ // null이 아닐 때만 연락처 정보 가져오기
            ContactInfo contactInfo= company1.getContactInfo();
            if (contactInfo!=null){
                addr1 = contactInfo.getAddr();
            }
        }
        if (addr1!=null){
            System.out.println(addr1);
        }
        else {
            System.out.println("주소 정보가 없습니다.");
        }




    }

}

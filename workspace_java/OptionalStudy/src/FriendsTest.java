import java.util.Optional;

public class FriendsTest {
    public static void main(String[] args) {
        ContactInfo contact = new ContactInfo("01011112222", "제주도");
        Company c = new Company("삼성", contact);
        Friends f = new Friends("고길동", c);

        originPrint(f);


        Optional<Friends> optional = Optional.ofNullable(f);

        optionalPrint(optional);
    }


    // 기존 방식 코드 : 주소 출력
    public static void originPrint(Friends f){
        String addr = null;
        if (f!=null){
            Company c=f.getCompany();
            if (c!=null){
                ContactInfo contact=c.getContactInfo();
                if (contact!=null){
                    addr = contact.getAddr();
                }
            }
        }
        if (addr!=null){
            System.out.println(addr);
        }
        else {
            System.out.println("주소를 찾을 수 없습니다.");
        }

    }

    // Optional 사용 코드
    public static void optionalPrint(Optional<Friends> optional){
        // Function<T> -> R apply(T t)
        String addr = optional.map(friends->friends.getCompany()) // Company 객체가 상자에 들어감
                .map(company -> company.getContactInfo()) // ContactInfo 객체가 상자에 들어감
                .map(contactInfo -> contactInfo.getAddr()) // String addr 들어감
                .orElse("주소를 찾을 수 없습니다.");

        System.out.println(addr);
    }


}

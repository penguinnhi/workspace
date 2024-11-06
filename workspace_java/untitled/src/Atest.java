import com.sun.source.tree.ReturnTree;
import com.sun.source.tree.WhileLoopTree;

public class Atest {
    public static void main(String[] args) {

//        int i, hap=0;
//        for (i=1;
//             i<=10;
//             ++i,
//                     hap+=i){
//        };
//        System.out.printf("%d, %d\n",i,hap);

//        int i=0, hap=0;
//        for (i=1;
//             i<=5;
//             ++i,
//                     hap+=i){
//            System.out.printf("합은 %d %4d입니다.\n",i,hap);
//        }

//        String str="1,2,3,4,,,5,6,7,,8,9";
//        String[] splittest = str.split(",");
//
//        for (int i=0;i<splittest.length;i++){
//            System.out.print(splittest[i]);
//            if ((i+1)%3==0){
//                System.out.println();
//            }
//        }


//        int i=200;
//        float a = 123.456f;
//        i=(int)a;
//        System.out.printf("%d, %3.2f"i,a);
//        return 0;
//
//    }

    int x=7;
    ClassB cal=new ClassB();
    cal.prn(x);


}

class ClassA{
        ClassA(){
            System.out.print('A');
            this.prn();
        }
        void prn(){
            System.out.print('B');
        }
}}

class ClassB extends ClassA {
    ClassB(){
        super();
        System.out.print('D');
    }
    void prn(){
        System.out.print('E');
    }
    void prn(int x){
        System.out.print(x);
    }

//    int n1=172;
//    int n2=387;
//
//    while(n1!=n2){
//        if (n1>n2) n1-=n2;
//        else n2-=n1;
//    }
//
//    printf("%d",n1);
//
//    return 0;



}

//bool numTest (int n){
//    int i=2;
//    if (n<2) return false;
//    else if (n==2) return true;
//
//    while(1){
//        if (n%i==0) return false;
//        else if (i*i>n) break;
//        i++;
//    }
//    return true;
//}
//
//int main(){
//    int j=0;
//    int res=0;
//    for (j=1;j<=20;j++){
//        if (numTest(j)) res+=j;
//    }
//    printf("%d",res);
//
//    return 0;
//}

int printBin(int a){
    if (a==0|a==1)printf("%d",a);
    else {
        printBin(a/2);
        printf("%d",a%2);
    }
}

int main(){
    int x=11;
    printBin(x);
    return 0;
}

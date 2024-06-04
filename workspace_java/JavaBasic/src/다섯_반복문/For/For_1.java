package 다섯_반복문.For;

public class For_1 {
    public static void main(String[] args) {
        /*int i=1;
        int cnt = 0;

        while (i<11){
            System.out.println(i);
            i++;
        }*/

        /// For ↓
        // for (1,2,4){
            //3
            //} (해석순서)
        /*
        for(int i=1; i<11; i++){
            if (i%2==0){
                System.out.println(i);
            }

        }*/

        //1부터 10까지의 합
        int sum = 0;
        for (int i=1; i<11; i++ ){

            sum+=i;


        } System.out.println(sum);



    }
}

public class Atest {
    public static void main(String[] args) {
        int[] arr1= {3,5,9,2,1,5};
        btest bt=new btest();
        bt.pa(arr1,2);

    }


}

class btest{
    void pa(int[] arr,int c){
        int i;
        if (c>1){
            for (i=0; i<arr.length; i++){
                if ((i+1)%c==0){
                    System.out.printf("%d",arr[i]);
                }

            }
        }
        else {
            for (i=0;i<arr.length;i++){
                System.out.printf("%d",arr[i]);
            }
        }
    }

}

package 여섯_배열;

public class Test_2_5 {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        int[] newArr=new int[5];
        newArr=arr;
        //newArr=arr.clone();


        for (int e:newArr){
            System.out.println(e);
        }

        //for(int i=0;i<arr.length;i++){
        //newArr[i]=arr[i];
        //}

    }
}

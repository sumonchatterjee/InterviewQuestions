package google;

/**
 * Created by sumon.chatterjee on 06/12/17.
 */


/*https://leetcode.com/problems/plus-one/description/*/
public class PlusOne {



    private int[] plusone(int[] arr){



         int length = arr.length;
            for(int j=length-1;j>=0;j-- ){

                if(arr[j]<9){
                    arr[j]++;
                    return arr;

                }


                arr[j]=0;

            }

            int[] newNumber = new int [length+1];
            newNumber[0] = 1;

            return newNumber;





    }


    public static void main(String[] args) {
        int[]arr={9,9,9};
        PlusOne one= new PlusOne();
        int[]c=one.plusone(arr);
        System.out.println("test");
    }
}

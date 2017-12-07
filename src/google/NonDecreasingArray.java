package google;

/**
 * Created by sumon.chatterjee on 04/12/17.
 */
public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] arr={4,2,3};
        NonDecreasingArray test= new NonDecreasingArray();
        if(test.isNonDecreasingArrayByModifyingElement(arr))
            System.out.println("yes");
        else
            System.out.println("no");
    }


    private boolean isNonDecreasingArrayByModifyingElement(int[] arr){
        int cont=0;
            for(int i=0;i<arr.length-1;i++){
                if(arr[i]>arr[i+1]){
                    cont+=1;
                }
            }



        if(cont>=2)
            return false;
   else
    return true;


    }


}

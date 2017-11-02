package amazon;

/**
 * Created by sumon.chatterjee on 26/07/17.
 */
public class IndexOfFirstOneInAnArray {


    private int indexOfFirstOne(int arr[],int low, int high) {

//        while(low<high){
//
//            int mid=(low+ high)/2;
//
//            if(arr[mid]==1 && (mid == 0 || arr[mid - 1] == 0)){
//                return mid;
//            }
//
//            // first '1' lies to the left of 'mid'
//            else if (arr[mid] == 1)
//                high = mid - 1;
//
//                // first '1' lies to the right of 'mid'
//            else
//                low = mid + 1;
//
//        }


        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] == 1 && arr[mid - 1] == 1)
                high = mid - 1;
            else if (arr[mid] == 0)
                low = mid + 1;
            else
                return mid;



        }
        return -1;
    }


    public static void main(String[] args){

        int arr[] = { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1 };
        int n = arr.length ;
        IndexOfFirstOneInAnArray test= new IndexOfFirstOneInAnArray();
        int index =test.indexOfFirstOne(arr,0,n-1);
        System.out.println("index is--------" + index);




    }
}

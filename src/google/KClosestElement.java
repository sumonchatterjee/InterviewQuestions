package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sumon.chatterjee on 08/12/17.
 */
public class KClosestElement {
    List<Integer> res= new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);


        KClosestElement closet= new KClosestElement();
        closet.findClosestttElements(arr,4,-1);

    }


    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        int lo = 0, hi = arr.size() - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr.get(mid) > arr.get(mid+k) - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        return arr.subList(lo, lo + k);
    }




    private void findClosest(List<Integer> arr,int x,int k){
        int i=0, j=0;
        int index = binarySearch(arr,x);

        if(index!=-1) {

            i = index - 1;
            j = index + 1;
            List<Integer> ans= compare(i, j, arr, x, k);

            for(int m=0;m<ans.size()-1;m++){
                System.out.println(ans.get(m));
            }

        }

    }

    private List<Integer>  compare(int i,int j,List<Integer> arr,int x,int k){
        while(i>=0 && j<=arr.size()-1) {
            if ((x - arr.get(i)) < (arr.get(j) - x)) {
                res.add(arr.get(i));
                i--;

            } else {
                res.add(arr.get(j));
                j++;
            }
            compare(i, j, arr, x, k);
        }
          return  res;
    }


    private int binarySearch(List<Integer> arr,int x){
        int low=0;
        int high=arr.size()-1;
        int index = searchElement(arr,low,high,x);
        return index;

        }


    private int searchElement(List<Integer>arr, int low, int high,int x) {
        int returnValue = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (x == arr.get(mid)) {
                returnValue =  mid;
                break;
            } else {
                if (x < arr.get(mid)) {
                    high = mid - 1;
                    returnValue = searchElement(arr, low, high, x);
                } else {
                    low = mid + 1;
                    returnValue = searchElement(arr, low, high, x);
                }
            }
        }
        return returnValue;

    }



    public List<Integer> findClosestttElements(List<Integer> arr, int k, int x) {
        int index = Collections.binarySearch(arr, x);
        if(index < 0) index = -(index + 1);
        int i = index - 1, j = index;
        while(k-- > 0){
            if(i<0 || (j<arr.size() && Math.abs(arr.get(i) - x) > Math.abs(arr.get(j) - x) ))j++;
            else i--;
        }
        return arr.subList(i+1, j);
    }
}


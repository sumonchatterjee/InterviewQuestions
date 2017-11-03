package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumon.chatterjee on 03/11/17.
 */
public class DegreeOfAnArray {

    private  Map.Entry<Integer,Integer>  maximumFrquencyOfElementInArray(int[]array){
        HashMap<Integer, Integer> hm = new HashMap();
        for (int i = 0; i < array.length; i++) {
            int key = (array[i]);
            if ( hm.containsKey(key) ) {
                Integer freq = hm.get(key);

                hm.put(key, freq + 1);
            } else {
                hm.put(key, 1);
            }

        }

        Map.Entry<Integer,Integer> maxEntry = null;

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }
        return maxEntry;
    }


    private void getdegree(int[] arr){
        HashMap<Integer, Integer> numbersByDegree = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int degree = numbersByDegree.getOrDefault(arr[i], 0);
            System.out.println("degree is "+degree);
            numbersByDegree.put(arr[i], degree + 1);
        }
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap(),
                right = new HashMap(), count = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) left.put(x, i);
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {

        int[]n={1,2,4,2,3,2,2};
        DegreeOfAnArray no=new DegreeOfAnArray();
        int v = no.findShortestSubArray(n);
        System.out.println("degree is - "+v);
//        Map.Entry<Integer, Integer> hm  = no.maximumFrquencyOfElementInArray(n);
//        System.out.println("Frequency is - "+hm.getValue());
//        System.out.println("Frequent element is is - "+hm.getKey());

    }
}

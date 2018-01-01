package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sumon.chatterjee on 23/12/17.
 */
public class LongestSubsequenceInArray {


    private int longestSubs(int[] arr){
     int ans=0;
        Set<Integer> nums= new HashSet<>();

        for(int i=0;i<arr.length;i++){
            nums.add(arr[i]);
        }

        for(int i=0;i<arr.length;i++){
            if (!nums.contains(arr[i]-1)){
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (nums.contains(j))
                    j++;

                // update  optimal length if this length
                // is more
                if (ans<j-arr[i])
                    ans = j-arr[i];
            }

        }


        return ans;
    }


    public static void main(String[] args) {
       int[] check = {2,1,6,9,4,3};
       LongestSubsequenceInArray arr = new LongestSubsequenceInArray();
       int result=arr.longestSubs(check);
        System.out.println("resut is "+ result);
    }
}

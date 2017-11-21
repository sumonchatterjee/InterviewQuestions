package facebookLeetcode;

import java.util.HashMap;

/**
 * Created by sumon.chatterjee on 06/11/17.
 */
public class FindMaximumSubarrayWithGivenSum {

    /*Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.*/
    /*Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
    Ouptut: Sum found between indexes 2 and 4
*/

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = 0;

        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];

            if(sum==k){
                max = Math.max(max, i+1);
            }

            int diff = sum-k;

            if(map.containsKey(diff)){
                max = Math.max(max, i-map.get(diff));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }


        return max;
    }

    public static void main(String[] args)
    {
        FindMaximumSubarrayWithGivenSum arraysum = new FindMaximumSubarrayWithGivenSum();
        int arr[] = {1, -1, 5, -2, 3};
        int sum = 3;
        System.out.println("answer "+arraysum.maxSubArrayLen(arr,sum));
    }
}

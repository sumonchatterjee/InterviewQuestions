package facebookLeetcode;

import java.util.Arrays;

/**
 * Created by sumon.chatterjee on 14/09/18.
 */
//watch this video
  //  https://www.youtube.com/watch?v=1RpMc3fv0y4

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len=0;
        if(nums.length==0)
            return 0;
        else{

            int n= nums.length;
            int[] increasingSequence = new int[n];
            increasingSequence[len++] = nums[0];
            for(int i=0;i<n;i++){
                if(nums[i] > increasingSequence[len-1]){  //first check if the current element is greater than all the elements in increasingSequence
                    increasingSequence[len++]=nums[i];
                }else {
                    int position = findPositionToReplace(increasingSequence, 0, len - 1, nums[i]);
                    increasingSequence[position] = nums[i];
                }
            }
        }
        return len;

    }


    public int findPositionToReplace(int[] a, int low, int high, int x){
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (a[mid] == x)
                return mid;
            else if (a[mid] > x)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

//dp solution
    public int lengthOfLISDPSolution(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
        return max;
    }

    public static void main(String[] args) {
        int[] arr ={10,9,2,5,3,7101,18};
        LongestIncreasingSubsequence bb = new LongestIncreasingSubsequence();
        System.out.println(""+bb.lengthOfLISDPSolution(arr));
    }
}

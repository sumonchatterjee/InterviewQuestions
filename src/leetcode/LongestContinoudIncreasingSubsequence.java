package leetcode;

/**
 * Created by sumon.chatterjee on 06/11/17.
 */
public class LongestContinoudIncreasingSubsequence {
    /*Given an unsorted array of integers, find the length of longest continuous increasing subsequence.*/
    /*Input: [1,3,5,4,7]
    Output: 3
    Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
    Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
    */

int findContinousIncreasingSubsequence(int[]arr){
    int anchor=0;
    int answer=0;

    for(int i=0;i<arr.length;++i){
        if(arr[i]>0 && arr[i-1] >= arr[i]) anchor = i;
        answer = Math.max(answer, i - anchor + 1);
    }
    return answer;

}


    public static void main(String[] args) {
        int[] a={7, 8, 9, 1, 2, 3};
        LongestContinoudIncreasingSubsequence bcs = new LongestContinoudIncreasingSubsequence();
        int c=bcs.findContinousIncreasingSubsequence(a);
        System.out.println("length is " + c);

    }


}

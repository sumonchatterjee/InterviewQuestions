package leetcode;

/**
 * Created by sumon.chatterjee on 03/11/17.
 */
public class MaximumSubArray {

    private int findMaximumSumOfSubArray(int[] a) {
        int max_so_far = 0;
        int max_sum = 0;

        int maxElement = maximumElementIngivenArray(a);
        if(maxElement<0)
            return maxElement;

            for (int i = 0; i < a.length; i++) {
                max_so_far = max_so_far + a[i];
                if (max_so_far < 0) {
                    max_so_far = 0;
                }

                if (max_so_far > max_sum) {
                    max_sum = max_so_far;
                }
            }


      return max_sum;


    }

    private int maximumElementIngivenArray(int[]n){
        int res = n[0];
        for(int i=1;i<n.length;i++){
            res= Math.max(res,n[i]);

        }
        return res;
    }


    public static void main(String[] args) {
        int[]ma = {-1,-2,3,4};
        MaximumSubArray ms= new MaximumSubArray();
        int sum=ms.findMaximumSumOfSubArray(ma);
        System.out.println("result is = "+sum);

    }
}

package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumon.chatterjee on 19/12/17.
 */
public class SummaryRanges {

    private List<String> getSummaryRanges(int[] nums){
        List<String> result=new ArrayList();

        int start= 0;
        int end =0;

        for(int i=0;i<nums.length;i++){
            while(i+1<nums.length && nums[i+1]-nums[i]==1){
                i++;
                end++;
            }

            if(nums[start]!=nums[i]){
                result.add(nums[start]+"->"+nums[i]);
                start=end+1;
            }
            else
                result.add(nums[start]+"");
        }
        return result;

    }


    public static void main(String[] args) {
        int[] arr= {2,3,7,8,10};
        SummaryRanges ranges = new SummaryRanges();
        ranges.getSummaryRanges(arr);
    }
}

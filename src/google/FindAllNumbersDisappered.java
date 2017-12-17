package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumon.chatterjee on 07/12/17.
 */
public class FindAllNumbersDisappered {


    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        FindAllNumbersDisappered tset= new FindAllNumbersDisappered();
        List<Integer> result=tset.findDisappearedNumbers(arr);


        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
    }


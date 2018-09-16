package facebookLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sumon.chatterjee on 13/09/18.
 */
public class ThreeSum {

    private List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> sl = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
            sl.put(nums[i], i);
        for(int i=0;i<nums.length-2;i++)
        {
            for(int j=i+1;j<nums.length-1;j++)
            {
                int target = 0-nums[i]-nums[j];
                if(sl.containsKey(target) && sl.get(target)>j)
                {
                    //j=sl.get(nums[j]);
                    res.add(Arrays.asList(nums[i], nums[j], target));
                }
            }
            i=sl.get(nums[i]);  // To remove duplicates
        }
        return res;
    }

  // this is
    private static ArrayList<ArrayList<Integer>> threeSumAnotherMethod(int[] arr){
      ArrayList<ArrayList<Integer>> results = new ArrayList<>();
      Arrays.sort(arr);

      for(int i=0;i<arr.length-3;i++){
          if(i==0 || arr[i]>arr[i-1]){
              int start = i+1;
              int end= arr.length-1;

              while(start<end){
                  if(arr[i]+arr[start]+arr[end] == 0){
                      ArrayList<Integer> mm =new ArrayList<>();
                      mm.add(arr[i]);
                      mm.add(arr[start]);
                      mm.add(arr[end]);

                      results.add(mm);
                  }
                  if(arr[i]+arr[start]+arr[end]<0){
                      int currentStart = start ;//for duplicates, skip the duplicates ones
                      while((arr[start]==arr[currentStart])) {
                          start ++;
                      }

                  }else{
                     int currentEnd = end;
                     while(arr[end] == arr[currentEnd]){
                          end--;
                     }
                  }
              }
          }
      }
      return  results;
    }


    public static void main(String[] args) {
        int[] arr ={-1,0,1,2,-1,-4};

        ThreeSum m =new ThreeSum();
        List<List<Integer>> result = m.threeSum(arr);
        System.out.println(result.size());

    }
}

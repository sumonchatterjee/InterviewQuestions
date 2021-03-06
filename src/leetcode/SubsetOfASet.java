package leetcode;

import java.util.ArrayList;

/**
 * Created by sumon.chatterjee on 25/12/17.
 */
public class SubsetOfASet {

    public static void main(String[] args) {
        ArrayList<Integer> nums= new ArrayList<>();
        nums.add(1);
        nums.add(2);

        SubsetOfASet sets= new SubsetOfASet();
        sets.getSubsets(nums,0);
    }

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // Empty set

        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);


            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }
}

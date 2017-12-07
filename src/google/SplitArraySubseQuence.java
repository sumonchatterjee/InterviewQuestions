package google;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by sumon.chatterjee on 05/12/17.
 */
public class SplitArraySubseQuence {


    public static void main(String[] args) {


        int[] arr={1,2,3,3,4,5};

        SplitArraySubseQuence cc= new SplitArraySubseQuence();
        boolean check = cc.isPossible(arr);
        if(check)
            System.out.println("true");
        else
            System.out.println("false");
    }




    private HashMap<Integer, PriorityQueue<Integer>> dmap;
    public boolean ispossible(int[] nums) {
        dmap = new HashMap<>();
        for (int num : nums) {
            PriorityQueue<Integer> pq0 = getOrPut(num - 1);
            int len = pq0.isEmpty() ? 0 : pq0.poll();
            PriorityQueue<Integer> pq1 = getOrPut(num);
            pq1.offer(len + 1);
        }
        for (int key : dmap.keySet()) {
            for (int len : dmap.get(key)) {
                if (len < 3) return false;
            }
        }
        return true;
    }
    public PriorityQueue<Integer> getOrPut(int num) {
        PriorityQueue<Integer> pq = dmap.get(num);
        if (pq == null) {
            pq = new PriorityQueue<Integer>();
            dmap.put(num, pq);
        }
        return pq;
    }




    public boolean isPossible(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Map<Integer, Integer> append = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int i : nums){
            if (map.get(i) == 0) continue;
            if (append.getOrDefault(i, 0) > 0){
                append.put(i, append.get(i) - 1);
                append.put(i + 1, append.getOrDefault(i + 1, 0) + 1);
            }
            else if (map.getOrDefault(i + 1, 0) > 0 && map.getOrDefault(i + 2, 0) > 0){ // 再独立
                map.put(i + 1, map.get(i + 1) - 1);
                map.put(i + 2, map.get(i + 2) - 1);
                append.put(i + 3, append.getOrDefault(i + 3, 0) + 1);
            }
            else return false;
            map.put(i, map.get(i) - 1);
        }
        return true;
    }
}

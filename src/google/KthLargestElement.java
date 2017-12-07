package google;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sumon.chatterjee on 27/11/17.
 */
public class KthLargestElement {


    public static void main(String[] args) {
        int[]c = {5,2,8,1,9};
        KthLargestElement elemnet= new KthLargestElement();
        int result = elemnet.findKthLargest(c,2);
        System.out.println("result is--"+result);
    }


    private int findKthLargest(int[]arr,int k){

            PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
            for(int i: arr){
                q.offer(i);
                if(q.size()>k){
                    q.poll();
                }
            }
            return q.peek();
        }





    public static Comparator<Integer> idComparator = new Comparator<Integer>(){

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-01;
        }
    };
}

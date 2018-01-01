package google;

import java.util.*;

/**
 * Created by sumon.chatterjee on 24/12/17.
 */
public class QueueReconstruction {


    public static void main(String[] args) {
        int arr[][]={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        QueueReconstruction cons= new QueueReconstruction();
        cons.reconstructQueue(arr);
    }

    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            if(cur[1]>=res.size())
                res.add(cur);
            else
                res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }
}

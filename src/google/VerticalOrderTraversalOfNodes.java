package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sumon.chatterjee on 05/12/17.
 */

/*Algo
https://www.youtube.com/watch?v=PQKkr036wRc&t=672s*/


public class VerticalOrderTraversalOfNodes {


    public static void main(String[] args) {

        TestNode root= new TestNode(10);
        root.left=new TestNode(9);
        root.right= new TestNode( 8);
        root.left.left= new TestNode( 6);
        root.left.right= new TestNode( 2);


        VerticalOrderTraversalOfNodes test= new VerticalOrderTraversalOfNodes();
        List<List<Integer>> cc=test.getVerticalTraversal(root);

    }

    private List<List<Integer>> getVerticalTraversal(TestNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>(); //return this
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(); //for storing horizontal distance (hd) and list of nodes of that level

        int minLevel = 0;
        int maxLevel = 0;

        if (root == null)
            return result;


        LinkedList<TestNode> queue = new LinkedList<>(); // queue for storing node visited
        LinkedList<Integer> horizontalDistance = new LinkedList<>(); // for storing horizontal distance

        //for root node and when traversing starts,put the root node in queue

        queue.offer(root);
        horizontalDistance.add(0);


        while (!queue.isEmpty()) {

            TestNode node = queue.poll();
            int hd = horizontalDistance.poll();

           // limit of horizontal distance
            minLevel = Math.min(minLevel, hd);
            maxLevel = Math.max(maxLevel, hd);

          //if already horizontal distance is present in map,
            // retrieve the list from the map with the horizontal distance
            //and then add the node value to this list.
            if (map.containsKey(hd)) {

                if(node!=null)
                map.get(hd).add(node.data);

            } else {

                ArrayList<Integer> list = new ArrayList<>();
                if(node!=null) {
                    list.add(node.data);
                    map.put(hd, list);
                }
            }


            // if left node, then horizontal distance-1
            if(node!=null) {
                if (node.left != null) {
                    queue.offer(node.left);
                    horizontalDistance.offer(hd - 1);
                }
            }


            //if right node, then horizontal distance + 1
            if(node!=null) {
                if (root.right != null) {
                    queue.offer(node.right);
                    horizontalDistance.offer(hd + 1);
                }

            }
        }



        for (int i =minLevel ;i<maxLevel;i++){
           if(map.containsKey(i))
               result.add(map.get(i));
        }

        return result;
    }


}

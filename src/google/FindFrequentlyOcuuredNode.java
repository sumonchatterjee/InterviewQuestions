package google;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sumon.chatterjee on 05/12/17.
 */
public class FindFrequentlyOcuuredNode {

    HashMap<Integer, Integer> map = new HashMap<>();
    int curval = 0;
    int curcount = 0;
    int[] mode;
    int maxcount = 0;
    int modecount = 0;


    public static void main(String[] args) {


        TestNode normalNode = new TestNode(7);
        normalNode.left = new TestNode(3);
        normalNode.right = new TestNode(8);
        normalNode.left.left = new TestNode(3);
        normalNode.left.right = new TestNode(4);
        FindFrequentlyOcuuredNode node = new FindFrequentlyOcuuredNode();
        int[] arr=node.findMode(normalNode);
        System.out.println("hello");


    }


    private void findFrquentlyOcuured(TestNode root) {


        if (root == null)
            return;


        if (map.containsKey(root.data)) {
            int val = map.get(root.data);
            map.put(root.data, val + 1);


        } else {
            map.put(root.data, 1);
        }

        findFrquentlyOcuured(root.left);
        findFrquentlyOcuured(root.right);

        int maxValueInMap = (Collections.max(map.values()));

        System.out.println("" +getKeyForMaxVal(maxValueInMap));


    }


    private int getKeyForMaxVal(int maxValueInMap) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxValueInMap) {
                return entry.getKey();
            }


        }

        return 0;
    }

    void printInorder(TestNode node)
    {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        //System.out.print(node.data + " ");
        handleval(node.data);

        /* now recur on right child */
        printInorder(node.right);
    }


    private void handleval(int val) {
        if (curval != val) {
            curval = val;
            curcount = 0;
        }
        curcount++;
        if (curcount > maxcount) {
            maxcount = curcount;
            modecount = 1;
        } else if (curcount == maxcount) {
            if (mode != null) {
                mode[modecount] = curval;
            }
            modecount++;
        }
    }


    public int[] findMode(TestNode root) {
        printInorder(root);
        mode = new int[modecount];
        curcount = 0;
        modecount = 0;
       // printInorder(root);
        return mode;
    }

    private void inorder(TestNode root) {
        TestNode node = root;
        while (node != null) {
            if (node.left == null) {
                handleval(node.data);
                node = node.right;
            } else {
                TestNode prev = node.left;
                while (prev.right != null && prev.right != node)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    handleval(node.data);
                    node = node.right;
                }
            }
        }
    }


}


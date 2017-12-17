package google;

import java.util.TreeSet;

/**
 * Created by sumon.chatterjee on 10/12/17.
 */
public class MinimumAbsoluteDifferenceinBST {

    int min = Integer.MAX_VALUE;
    Integer prev = null;


    public static void main(String[] args) {
        Node root = new Node(8);
        root.right = new Node(10);
        root.left = new Node(5);
        root.right.left=new Node(9);
        MinimumAbsoluteDifferenceinBST bst= new MinimumAbsoluteDifferenceinBST();
        bst.getMinimumDifference(root);

    }

    //if tree is bst
    public int getMinimumDifference(Node root) {
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.data - prev);
        }
        prev = root.data;

        getMinimumDifference(root.right);

        return min;
    }


    //if tree is not bst, use tree set
    TreeSet<Integer> set = new TreeSet<>();


    public int getMinimumsDifference(Node root) {
        if (root == null) return min;

        if (!set.isEmpty()) {
            if (set.floor(root.data) != null) {
                min = Math.min(min, root.data - set.floor(root.data));
            }
            if (set.ceiling(root.data) != null) {
                min = Math.min(min, set.ceiling(root.data) - root.data);
            }
        }

        set.add(root.data);

        getMinimumsDifference(root.left);
        getMinimumsDifference(root.right);

        return min;
    }
}

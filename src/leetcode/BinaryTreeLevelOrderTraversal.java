package leetcode;

import java.util.*;

/**
 * Created by sumon.chatterjee on 21/11/17.
 */
/*
Given binary tree [3,9,20,null,null,15,7]
        3
        / \
        9  20
        /  \
        15   7

        [
        [3],
        [9,20],
        [15,7]
        ]*/

public class BinaryTreeLevelOrderTraversal {

    static public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList();
        List levelResult = new ArrayList();

        Queue queue = new LinkedList();
        queue.offer(root);
        queue.offer(null);

        TreeNode node = null;
        while(! queue.isEmpty()){
            node = (TreeNode) queue.poll();
            if(node != null){
                levelResult.add(node.val);
            }
            if(queue.size() > 0 && node == null){
                results.add(levelResult);
                levelResult = new ArrayList();
                queue.offer(null);
            }
            if(node!=null && node.left != null){
                queue.offer(node.left);
            }

            if(node != null && node.right != null){
                queue.offer(node.right);
            }

        }
        results.add(levelResult);

        return results;
    }


    public static void main(String[] args) {

        BinaryTreeLevelOrderTraversal traversal = new BinaryTreeLevelOrderTraversal();
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right=new TreeNode(4);
        node.left.left=new TreeNode(6);
        node.left.right=new TreeNode(7);
        List<List<Integer>>  bb = traversal.levelOrder(node);
        System.out.println("end");

    }



}

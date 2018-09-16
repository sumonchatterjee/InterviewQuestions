package facebookLeetcode;

import leetcode.BinaryTreeLevelOrderTraversal;
import leetcode.InorderSuccesorInBst;

/**
 * Created by sumon.chatterjee on 16/09/18.
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(InorderSuccesorInBst.TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean checkBST(InorderSuccesorInBst.TreeNode root, long min, long max) {
        if (root == null)	return true;
        if (root.val <= min || root. val>= max)		return false;
        return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
        // if (!checkBST(root.left, min, root.val))    return false;
        // if (!checkBST(root.right, root.val, max))   return false;
        // return true;
    }
}

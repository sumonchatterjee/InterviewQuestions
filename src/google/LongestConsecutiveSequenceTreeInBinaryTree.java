package google;

/**
 * Created by sumon.chatterjee on 04/12/17.
 */
public class LongestConsecutiveSequenceTreeInBinaryTree {




    private void findLongestConsecutiveSequence(Node root,int expectedData,int currentLength,int res){

        if(root==null)
            return;

        if (root.data == expectedData)
            currentLength++;
        else
            currentLength = 1;

        res = Math.max(res, currentLength);
        findLongestConsecutiveSequence(root.left, root.data+1,
                currentLength, res);
        findLongestConsecutiveSequence(root.right, root.data+1,
                currentLength, res);
    }



    private int lengthOfLongestConsecutiveSubsequence(Node root){
        if (root == null)
            return 0;

        int res = 0;

        findLongestConsecutiveSequence(root, 0, root.data, res);

        return res;
    }


    public static void main(String[] args) {
        Node root = new Node(6);
        root.right = new Node(9);
        root.right.left = new Node(7);
        root.right.right = new Node(10);
        root.right.right.right = new Node(11);
        LongestConsecutiveSequenceTreeInBinaryTree tree=new LongestConsecutiveSequenceTreeInBinaryTree();
        tree.lengthOfLongestConsecutiveSubsequence(root);
    }
}

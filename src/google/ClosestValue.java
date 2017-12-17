package google;

/**
 * Created by sumon.chatterjee on 12/12/17.
 */
public class ClosestValue {

    public static void main(String[] args) {

        ClosestValue v= new ClosestValue();

    }

    public int ClosesttValue(Node root, double target)
    {
        if (root == null) return 0;

        int val = root.data;
        double bestDiff = Math.abs(target - val);
        Node node = root;
        while (node != null)
        {
            double diff = Math.abs(target - node.data);
            if (diff <= bestDiff)
            {
                bestDiff = diff;
                val = node.data;
            }
            node = target <= node.data ? node.left : node.right;
        }

        return val;
    }
}

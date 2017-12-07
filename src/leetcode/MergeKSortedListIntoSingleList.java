package leetcode;

import java.util.ArrayList;

/**
 * Created by sumon.chatterjee on 22/11/17.
 */
public class MergeKSortedListIntoSingleList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode resultList = null;
        for(ListNode listNode : lists) {
            resultList = mergeTwoListNodes(resultList, listNode);
        }
        return resultList;
    }

    public ListNode mergeTwoListNodes(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(0);
        ListNode move = result;

        while (node1 != null || node2 != null) {
            int temp = 0;
            if (node1 == null && node2 != null) {
                temp = node2.val;
                node2 = node2.next;
            }

            if(node2 == null && node1 != null) {
                temp = node1.val;
                node1 = node1.next;
            }

            if (node1 != null && node2 != null) {
                if (node1.val <= node2.val) {
                    temp = node1.val;
                    node1 = node1.next;
                } else {
                    temp = node2.val;
                    node2 = node2.next;
                }
            }
            move.next = new ListNode(temp);
            move = move.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        MergeKSortedListIntoSingleList list =  new MergeKSortedListIntoSingleList();
        ArrayList<ListNode> listOfNodes = new ArrayList<>();
        ListNode root = new ListNode(2);
        root.next= new ListNode(4);
        root.next.next=new ListNode(5);
        listOfNodes.add(root);


        ListNode root1 = new ListNode(3);
        root1.next= new ListNode(6);
        root1.next.next=new ListNode(8);
        listOfNodes.add(root1);


        ListNode root2 = new ListNode(9);
        root2.next= new ListNode(10);
        root2.next.next=new ListNode(11);
        listOfNodes.add(root2);

        ListNode result = list.mergeKLists(listOfNodes);

    }

}

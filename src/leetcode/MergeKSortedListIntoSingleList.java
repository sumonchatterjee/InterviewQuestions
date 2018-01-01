package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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



    //another option mentionend in leetcode
    public static ListNode mergeKsLists(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists. complexity o(nlogk)
    //merge takes O(n) time and partition takes O(logk) time

    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }



//with proirity queue solution
    public ListNode mergeKListsithPriority(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKSortedListIntoSingleList list =  new MergeKSortedListIntoSingleList();


        ListNode[]nodes= new ListNode[6];


        ArrayList<ListNode> listOfNodes = new ArrayList<>();
        ListNode root = new ListNode(2);
        root.next= new ListNode(4);
        root.next.next=new ListNode(5);
        listOfNodes.add(root);

        nodes[0]=root;

        ListNode root1 = new ListNode(3);
        root1.next= new ListNode(6);
        root1.next.next=new ListNode(8);
        listOfNodes.add(root1);
nodes[1]=root1;

        ListNode root2 = new ListNode(9);
        root2.next= new ListNode(10);
        root2.next.next=new ListNode(11);
        listOfNodes.add(root2);

        nodes[2]=root2;

        ListNode result = list.mergeKListsithPriority(listOfNodes);

        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }

    }

}

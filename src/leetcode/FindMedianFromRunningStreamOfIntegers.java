package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Vector;

/**
 * Created by sumon.chatterjee on 19/11/17.
 */

/*
Two heaps: o(logn)
        Max heap: Smaller half
        Min heap: Larger half
        Size diff <= 1 --> same size: average of the top elements of the two heaps. Total even
        --> different size: The top element of the heap with larger size. Total odd

        addNum o(logn)
        Push: o(logn)
        optional rebalance: O(logn)
        findMedian o(1)
*/

public class FindMedianFromRunningStreamOfIntegers {


    PriorityQueue<Integer> firstQ = new PriorityQueue<>(); //max heap
    PriorityQueue<Integer> secQ = new PriorityQueue<>(new Comparator<Integer>() { //min heap
        @Override
        public int compare(Integer o1, Integer o2) {
            return -1 * o1.compareTo(o2);
        }
    });


    private void addNumIntoStream(int num) {
        if (secQ.isEmpty() || num < secQ.peek()) {
            secQ.add(num);
        } else {
            firstQ.add(num);
        }

        //rebalance if Size diff <= 1
        // (if, first queue is bigger in size, push element to second queue, removing top element from first queue)
        // get the bigger and the smaller heap by checking the size

        PriorityQueue<Integer> biggerHeap = secQ.size() > firstQ.size() ? secQ : firstQ;
        PriorityQueue<Integer> lowerHeap = secQ.size() > firstQ.size() ? firstQ : secQ;


        if (biggerHeap.size() - lowerHeap.size() >= 2) {
            lowerHeap.add(biggerHeap.poll());
        }


    }


    private double findMedian() {

        PriorityQueue<Integer> biggerHeap = secQ.size() > firstQ.size() ? secQ : firstQ;
        PriorityQueue<Integer> lowerHeap = secQ.size() > firstQ.size() ? firstQ : secQ;
        if (biggerHeap.size() == lowerHeap.size()) {
            return ((double)(biggerHeap.peek() + lowerHeap.peek()) / 2);
        } else {
            return biggerHeap.peek();
        }

    }



    public static void main(String[] args) {
        FindMedianFromRunningStreamOfIntegers runningStreamOfIntegers = new FindMedianFromRunningStreamOfIntegers();
        runningStreamOfIntegers.addNumIntoStream(6);
        runningStreamOfIntegers.addNumIntoStream(2);
        runningStreamOfIntegers.addNumIntoStream(3);
        runningStreamOfIntegers.addNumIntoStream(4);
        double val = runningStreamOfIntegers.findMedian();
        System.out.println(val + "");
    }
}

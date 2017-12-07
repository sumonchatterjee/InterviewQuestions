package google;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sumon.chatterjee on 06/12/17.
 */

/*Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
        MovingAverage m = new MovingAverage(3);
        m.next(1) = 1
        m.next(10) = (1 + 10) / 2
        m.next(3) = (1 + 10 + 3) / 3
        m.next(5) = (10 + 3 + 5) / 3 */

public class MovingAverageFromDataStream {


    Queue<Integer> queue;
    int n;
    int sum;


    MovingAverageFromDataStream(int sizeOfWindow) {
        queue= new LinkedList<>();
        this. n= sizeOfWindow;
        sum=0;
    }


    private double getMovingAverageFromAsetOfData(int val){

        queue.offer(val);
        double result=0;

        sum+=val;

        if(queue.size()<n){

            result =(double) sum/queue.size();
        }

        else{
            int remove = queue.poll();
            sum-=remove;
            result=(double) sum/n;
        }



       return result;

    }


    public static void main(String[] args) {
        MovingAverageFromDataStream m = new MovingAverageFromDataStream(3);
        System.out.println("1st "+m.getMovingAverageFromAsetOfData(1));
        System.out.println("2nd "+m.getMovingAverageFromAsetOfData(2));
        System.out.println("3rd "+m.getMovingAverageFromAsetOfData(3));
        System.out.println("4th "+m.getMovingAverageFromAsetOfData(4));
        System.out.println("5th "+m.getMovingAverageFromAsetOfData(5));

    }



}

package amazon;

import sun.jvm.hotspot.utilities.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by sumon.chatterjee on 01/08/17.
 */

/**Given a set of time intervals in any order, merge all overlapping intervals into one and output
        the result which should have only mutually exclusive intervals.
        Let the intervals be represented as pairs of integers for simplicity.
        For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }.
        The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}.
        Similarly {5, 7} and {6, 8} should be merged and become {5, 8} */



public class OverlappingIntervals {


    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals==null ||intervals.size()<2){
            return intervals;
        }

        ArrayList<Interval> result=new ArrayList<Interval>();

        Comparator<Interval> intervalComperator=new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                Integer i1St=i1.start;
                Integer i2St=i2.start;
                return i1St.compareTo(i2St);

            }
        };

        Collections.sort(intervals, intervalComperator);

        Interval current=intervals.get(0);

        int i=1;

        while (i<intervals.size() ){
            Interval currentToCompare=intervals.get(i);
            if (current.end<currentToCompare.start){
                result.add(current);
                current=currentToCompare;

            }
            else{
                current.end=Math.max(current.end, currentToCompare.end);

            }
            i++;
        }

        result.add(current);

        return result;
    }



    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int c = in.nextInt();

            int a[] = new int[c];

            for (int j = 0; j < c; j++) {
                a[j] = in.nextInt();

                OverlappingIntervals ovl = new OverlappingIntervals();
                ArrayList<Interval> vv = ovl.check(a);
                ArrayList<Interval> mmm;
                mmm = ovl.merge(vv);

for(int p=0;p<mmm.size();p++){

    Interval q = mmm.get(p);
    System.out.println("start------ " + q.start);
    System.out.println("end------ " + q.end);
}

            }

        }
    }


    private ArrayList<Interval>  check(int a[]){
        ArrayList<Interval> intervals = new ArrayList<>();
        if (a.length > 2){
            for(int k=0;k< a.length;k++){
                Interval v= new Interval(a[k],a[k+1]);
                intervals.add(v);

            }
        }
        return intervals;
    }
}

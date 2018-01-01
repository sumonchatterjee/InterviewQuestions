package google;

import sun.jvm.hotspot.utilities.Interval;

import java.util.*;

/**
 * Created by sumon.chatterjee on 18/12/17.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals interval = new MergeIntervals();
        List<Interval> result= new ArrayList<>();
        result.add(new Interval(2,6));
        result.add(new Interval(8,10));

        result.add(new Interval(1,3));

        result.add(new Interval(15,18));
        interval.merge(result);


    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
       // intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));


        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    static public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
}

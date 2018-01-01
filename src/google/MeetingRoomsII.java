package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sumon.chatterjee on 28/12/17.
 */
/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
        find the minimum number of conference rooms required.
*/
/*For example, Given [[0, 30],[5, 10],[15, 20]], return 2.*/
public class MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval ia, Interval ib){
                return ia.start - ib.start;
            }
        });

        PriorityQueue<Integer> minEndTimes = new PriorityQueue<>();
        minEndTimes.offer(intervals[0].end);
        for(int i = 1; i < intervals.length; i++) {

            if (intervals[i].start >= minEndTimes.peek()) {
                minEndTimes.poll();
            }
                minEndTimes.offer(intervals[i].end);

        }

        return minEndTimes.size();
    }



    class Interval{
        int start;
        int end;
    }
}

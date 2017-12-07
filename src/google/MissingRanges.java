package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumon.chatterjee on 06/12/17.
 */
public class MissingRanges {
    List<String> ranges = new ArrayList<>();

    private String getRange(int from, int to) {
        return (from == to) ? String.valueOf(from) : from + "->" + to;
    }

//done by me, working fine
    private List<String> getMissingRange(int[] val, int start, int end) {

        if (val.length == 0) {
            ranges.add(getRange(start, end));
        }


        if (val[0] != start) {
            int from = start;
            int to = val[0] - start;
            ranges.add(getRange(from, to));
        }


        if (val[val.length - 1] != end) {
            int from = val[val.length - 1] + 1;
            int to = end;
            ranges.add(getRange(from, to));
        }

        for (int i = 0; i < val.length; i++) {
            int len = val.length;
            if (i != len - 1)

            {
                if (val[i + 1] - val[i] == 1)
                    continue;

                else {
                    int from = val[i] + 1;
                    int to = val[i + 1] - 1;

                    ranges.add(getRange(from, to));
                }

        }
    }
        return ranges;
    }


    //optimized version
    public List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> ranges = new ArrayList<>();
        int prev = start - 1;
        for (int i = 0; i <= vals.length; i++) {
            int curr = (i == vals.length) ? end + 1 : vals[i];
            if (curr - prev >= 2) {
                ranges.add(getRange(prev + 1, curr - 1));
            }
            prev = curr;
        }
        return ranges;
    }


    public static void main(String[] args) {
        int[] arr={ 0, 1, 3, 50, 75};
        MissingRanges test= new MissingRanges();
        List<String> result  =test.findMissingRanges(arr,0,99);


        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }

    }
}

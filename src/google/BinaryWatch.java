package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumon.chatterjee on 08/12/17.
 */
public class BinaryWatch {

    //binary watch
    public List<String> readBinaryWatch(int num) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    result.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        BinaryWatch lis1t = new BinaryWatch();
        lis1t.readBinaryWatch(1);
    }
}

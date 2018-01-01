package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sumon.chatterjee on 26/12/17.
 */
public class Flipgame {


    private void flipGame1(String str) {
        List<String> result = new ArrayList<String>();
        if (str.length() > 0) {
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] == '+' && arr[i + 1] == '+') {
                    arr[i] = '-';
                    arr[i + 1] = '-';
                    result.add(new String(arr));
                }
                arr[i] = '+';
                arr[i + 1] = '+';
            }
        }

    }

    public boolean solution2(String str){
        if (str.length() > 0) {
            char[] s = str.toCharArray();
            for (int i = 0; i < s.length - 1; i++) {
                if (s[i] == '+' && s[i + 1] == '+') {
                    s[i] = '-';
                    s[i + 1] = '-';
                    boolean theOtherCanWin = solution2(new String(s));
                    s[i] = '+';
                    s[i + 1] = '+';
                    if (!theOtherCanWin) { //if there is a flip,so that other player looses,first player wins
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Flipgame cc= new Flipgame();
        cc.solution2("++++");
    }
}

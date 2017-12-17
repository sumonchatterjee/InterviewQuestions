package google;

/**
 * Created by sumon.chatterjee on 10/12/17.
 */


/*
confusions
https://github.com/lzl124631x/LeetCode/tree/master/leetcode/604.%20Design%20Compressed%20String%20Iterator*/
/*https://leetcode.com/articles/desing-compressed-string-iterator/*/
public class StringIterator {

        String res;
        int ptr = 0, num = 0;
        char ch = ' ';

        public StringIterator(String s) {
            res = s;
        }
        public char next() {
            if (!hasNext())
                return ' ';
            if (num == 0) {
                ch = res.charAt(ptr++);
                while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                    num = num * 10 + res.charAt(ptr++) - '0';
                }
            }
            num--;
            return ch;
        }
        public boolean hasNext() {
            return ptr != res.length() || num != 0;
        }
    }



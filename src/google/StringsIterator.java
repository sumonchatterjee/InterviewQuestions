package google;

import java.util.Arrays;

/**
 * Created by sumon.chatterjee on 10/12/17.
 */
/*https://leetcode.com/articles/desing-compressed-string-iterator/*/
public class StringsIterator {



        int ptr = 0;
        String[] chars;int[] nums;
        public StringsIterator(String compressedString) {
            String[] sub = compressedString.substring(1).split("[a-zA-Z]+"); // spllit the string to contain the numbers only
            nums = Arrays.stream(sub).mapToInt(Integer::parseInt).toArray();; //converted the string array sub to int array
            chars = compressedString.split("[0-9]+"); //split string to contain only characters only
        }
        public char next() {
            if (!hasNext())
                return ' ';
            nums[ptr]--;
            char res=chars[ptr].charAt(0);
            if(nums[ptr]==0)
                ptr++;
            return res;
        }
        public boolean hasNext() {
            return ptr != chars.length;
        }
    }


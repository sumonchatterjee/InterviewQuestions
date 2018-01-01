package leetcode;

import java.util.ArrayList;

/**
 * Created by sumon.chatterjee on 25/12/17.
 */

//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
public class PermutationsOfString {

    public static ArrayList<String> getPerms(String s) {
        ArrayList<String> permutations = new ArrayList<String>();

        if (s == null) { // error case
            return null;
        } else if (s.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }
            char rst = s.charAt(0); // get the  rst character
            String remainder = s.substring(1);
            ArrayList<String> words = getPerms(remainder);
            for (String word : words) {
                for (int j = 0; j <= word.length(); j++) {
                    permutations.add(insertCharAt(word, rst, j));
                }
            }
            return permutations;
        }


    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }


    public static void main(String[] args) {
       getPerms("abc");

    }



    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}



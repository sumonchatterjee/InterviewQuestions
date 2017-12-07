package google;

import java.util.HashMap;

/**
 * Created by sumon.chatterjee on 30/11/17.
 */
public class LengthOfNDistinctSubString {


    //longest substring at k distinct character


    //time complexity o(n)
    public static void main(String[] args) {
        LengthOfNDistinctSubString test = new LengthOfNDistinctSubString();
       // test.lengthOfLongestSubstringKDistinct("abcadcacacaca", 3);
        test.reverseWords("i love");
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0 || s == null || s.length() == 0)
            return 0;

        if (s.length() < k)
            return s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int maxLen = k;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

            if (map.size() > k) {
                maxLen = Math.max(maxLen, i - left); //this is basically end-start (where i serves as end)

                while (map.size() > k) {

                    char fc = s.charAt(left);
                    if (map.get(fc) == 1) {
                        map.remove(fc);
                    } else {
                        map.put(fc, map.get(fc) - 1);
                    }

                    left++;
                }
            }

        }

        maxLen = Math.max(maxLen, s.length() - left);
        String c = s.substring(left, maxLen + left);
        System.out.println("longest substring " + c);

        return maxLen;
    }

    private void reverseWords(String s) {

        char[]arr=s.toCharArray();

        int i=0;
        for(int j=0;j<arr.length;j++){
            if(arr[j]==' '){
                reverse(arr,i,j-1);
                i=j+1;
            }
        }

        reverse(arr,i,arr.length-1);
        reverse(arr,0,arr.length-1);
        String v = String.valueOf(arr);;
        System.out.println(v);

    }


    private void reverse(char[] str, int i,int j){

        while ((i<j)){

            Character temp= str[i];
            str[i]=str[j];
            str[j]=temp;
            i++;
            j--;


        }

    }



}


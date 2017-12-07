package google;

/**
 * Created by sumon.chatterjee on 04/12/17.
 */
public class ReverseString2 {


    public static void main(String[] args) {
        ReverseString2 str= new ReverseString2();
        str.reverseStr("abcdefg",2);
        boolean check=str.isCapital("FlaG");
        if(check)
            System.out.println("true");
        else
            System.out.println("false");
    }

    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }



    private boolean isCapital(String word){
        int numUpper = 0;
        for (int i=0;i<word.length();i++) {
            if (Character.isUpperCase(word.charAt(i)))
                numUpper++;
        }
        if (numUpper == 0 || numUpper == word.length()) return true;
        if (numUpper == 1) return Character.isUpperCase(word.charAt(0));
        return false;
    }






    static boolean isLowerCase(char ch) {
        return ch >= 'a' && ch <= 'z';
    }

    static boolean isUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }
}

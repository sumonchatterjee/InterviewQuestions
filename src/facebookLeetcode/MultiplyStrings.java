package facebookLeetcode;

/**
 * Created by sumon.chatterjee on 13/09/18.
 */
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int val1 = myStringToInteger(num1);
        int val2 = myStringToInteger(num2);
        long v = Long.parseLong(String.valueOf(val1));
        long z=  Long.parseLong(String.valueOf(val2));
        long result = v * z;
        String str =  result+"";

        return str;
    }

    //str = "        1          3            2      5             "
    //             thousand    hundred      ten     one

    public static int myStringToInteger(String str) {
        int answer = 0, factor = 1;
        for (int i = str.length()-1; i >= 0; i--) {
            answer += (str.charAt(i) - '0') * factor;
            factor *= 10;
        }
        return answer;
    }

    public static void main(String[] args) {
        String st1 ="12";
        String str2 ="6";
        System.out.println(multiply(st1,str2));

    }
}

package google;

import java.util.Stack;

/**
 * Created by sumon.chatterjee on 06/12/17.
 */
public class DecodeString {


    public static void main(String[] args) {
        DecodeString ff= new DecodeString();
        String data=ff.decodeString("10[a]");
    }

    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
       // int i = 0;
        result.push("");
        for (int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                    i++;                 // if number is of two or three digit, hence i has been added, do a substring and add it
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
           // i += 1;
        }
        return result.pop();
    }
}

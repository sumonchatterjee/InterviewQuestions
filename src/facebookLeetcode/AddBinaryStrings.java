package facebookLeetcode;

/**
 * Created by sumon.chatterjee on 08/11/17.
 */
public class AddBinaryStrings {


    private String addBinaryString(String a, String b){

        int l1 = a.length();
        int l2 = b.length();

        StringBuilder sum = new StringBuilder("");
        int carry = 0;

        int max = Math.max(l1, l2);
        for(int i = 0; i < max; i++){
            int m = getBit(a, l1 - i - 1);
            int n = getBit(b, l2 - i - 1);
            int add = m + n + carry;
            sum.append(add % 2);
            carry = add / 2;
        }

        if(carry == 1)
            sum.append("1");

        return sum.reverse().toString();
    }


    public int getBit(String s, int index){
        if(index < 0 || index >= s.length())
            return 0;

        if(s.charAt(index) == '0')
            return 0;
        else
            return 1;

    }
}

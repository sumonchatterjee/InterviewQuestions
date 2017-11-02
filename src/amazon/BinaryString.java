package amazon;

import java.util.Scanner;

/**
 * Created by sumon.chatterjee on 03/08/17.
 */
public class BinaryString {


    private int numberofSubstringStartingAndEndingWith1(char[]a){


        int noOfSubstring=0;
        int len = a.length;
        int count=0;
        for(int i=0;i<len;i++){

            if(a[i] == '1'){
                count++;
            }

        }


        noOfSubstring = count * (count - 1) / 2;

        return noOfSubstring;


    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int c = in.nextInt();
            char a[] = new char[c];
            String s = in.next();
            for (int j = 0; j < c; j++) {
                a[j]= s.charAt(j);
            }

            BinaryString bs= new BinaryString();

            int count = bs.numberofSubstringStartingAndEndingWith1(a);
            System.out.println(""+count);
        }
    }
}

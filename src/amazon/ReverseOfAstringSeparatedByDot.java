package amazon;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sumon.chatterjee on 05/09/17.
 */
public class ReverseOfAstringSeparatedByDot {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int c = sc.nextInt();
        for(int j=0;j<c;j++){
            String b[] = new String[c];

            for(int m=0;m<c;m++){
                b[m] = sc.nextLine();

            }

            for(int l=0;l<b.length;l++){

                ReverseOfAstringSeparatedByDot reverse = new ReverseOfAstringSeparatedByDot();
                String value = reverse.getReversedString(b[l]);
                System.out.println(value);
            }

        }
    }



    private String getReversedString(String statement){
        String result= "";
        if(statement.length()>0){
            Stack<String> myStack = new Stack<String>();
            String[] fn = statement.split("\\.");

            for(int i=0;i<fn.length;i++){
                myStack.push(fn[i]);
            }

            while (!myStack.isEmpty()) {
                String val = myStack.pop();
                if (!result.isEmpty()) {
                    result += ".";
                }
                result += val;


            }

        }
        return result;

    }
}

package google;

import java.util.List;

/**
 * Created by sumon.chatterjee on 23/12/17.
 */
public class PerfectSquare {

    static int getMinSquares(int n)
    {
        // base cases
        if (n <= 3)
            return n;

        // getMinSquares rest of the table using recursive
        // formula
        int res = n; // Maximum squares required is
        // n (1*1 + 1*1 + ..)

        // Go through all smaller numbers
        // to recursively find minimum
        for (int x = 1; x <= n; x++)
        {
            int temp = x*x;
            if (temp > n)
                break;
            else
                res =  Math.min(res, 1+getMinSquares(n - temp));
        }
        return res;
    }


    //perfect square with dp
    static int getsMinSquares(int n)
    {
        // Create a dynamic programming table
        // to store sq
        int dp[] = new int[n+1];

        // getMinSquares table for base case entries
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // getMinSquares rest of the table using recursive
        // formula
        for (int i = 4; i <= n; i++)
        {
            // max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
            dp[i] = i;

            // Go through all smaller numbers to
            // to recursively find minimum
            for (int x = 1; x <= i; x++) {
                int temp = x*x;
                if (temp > i)
                    break;
                else dp[i] = Math.min(dp[i], 1+dp[i-temp]);
            }
        }

        // Store result and free dp[]
        int res = dp[n];

        return res;
    }







    public static void main(String args[])
    {
        System.out.println(getMinSquares(6));
    }
}

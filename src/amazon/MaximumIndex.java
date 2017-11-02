package amazon;

import java.util.Scanner;

/**
 * Created by sumon.chatterjee on 02/08/17.
 */
public class MaximumIndex {


    /* Utility Functions to get max and minimum of two integers */
    int max(int x, int y)
    {
        return x > y ? x : y;
    }

    int min(int x, int y)
    {
        return x < y ? x : y;
    }

    /* For a given array arr[], returns the maximum j-i such that
       arr[j] > arr[i] */
    int maxIndexDiff(int arr[], int n)
    {
        int maxDiff;
        int i, j;

        int RMax[] = new int[n];
        int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = arr[0];
        for (i = 1; i < n; ++i)
            LMin[i] = min(arr[i], LMin[i - 1]);

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = arr[n - 1];
        for (j = n - 2; j >= 0; --j)
            RMax[j] = max(arr[j], RMax[j + 1]);

        for (int ii = 0; ii < n; ii++) {
            System.out.print(LMin[ii] + " ");
        }
        System.out.println();

        for (int ii = 0; ii < n; ii++) {
            System.out.print(RMax[ii] + " ");
        }
        System.out.println();

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
        i = 0; j = 0; maxDiff = 0;
        while (j < n && i < n)
        {
            if (LMin[i] < RMax[j])
            {
                maxDiff = max(maxDiff, j - i);
                j = j + 1;
            }
            else
                i = i + 1;
        }

        return maxDiff;
    }



    public static void main(String[] args)
    {
        MaximumIndex max = new MaximumIndex();


        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int c = in.nextInt();
            int a[] = new int[c];

            for (int j = 0; j < c; j++) {
                a[j] = in.nextInt();

            }

            int n = a.length;
            int maxDiff = max.maxIndexDiff(a, n);
            System.out.print("" + maxDiff);


        }

    }





    }



package amazon;

/**
 * Created by sumon.chatterjee on 01/08/17.
 */

import java.util.Arrays;
import java.util.Scanner;

/**Given an array of integers, sort the array into a wave like array and return it.
        In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

        Example

        Given [1, 2, 3, 4]

        One possible answer : [2, 1, 4, 3]
        Another possible answer : [4, 1, 3, 2]
  NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.*/



   public class WaveArray {

    private int[] getWaveArray(int[] arr) {

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i += 2) {

           swap(arr, i, i + 1);


        }
        return arr;

    }


    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {

//int a[]={5 ,7, 3 ,2 ,8};

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int c = in.nextInt();
            int a[] = new int[c];

            for (int j = 0; j < c; j++) {
                a[j] = in.nextInt();

            }


            WaveArray arr = new WaveArray();
            int[]arra = arr.getWaveArray(a);


            for (int l : arra)
                System.out.print(l + " ");


        }

    }
}

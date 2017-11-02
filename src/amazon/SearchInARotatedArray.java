package amazon;


import java.util.Scanner;

/**
 * Created by sumon.chatterjee on 03/08/17.
 */
public class SearchInARotatedArray {


    private int searchInASortedRotatedArray(int noToFind, int[] a, int low, int high) {

        int len = a.length;

        int mid = (low + high) / 2;

        if (a[mid] == noToFind) {
            return mid;
        }

/* If arr[l...mid] is sorted */
        if (a[low] <= a[mid]) {
            if (noToFind >= a[low] && noToFind <= a[mid]) {
                return searchInASortedRotatedArray(noToFind, a, low, mid - 1);
            } else {

                return searchInASortedRotatedArray(noToFind, a, mid + 1, high);
            }
        }


//if left side is not sorted, then right side will definately sorted
        else {
            if (noToFind >= a[mid] && noToFind <= a[high]) {
                return searchInASortedRotatedArray(noToFind, a, mid + 1, high);
            } else {

                return searchInASortedRotatedArray(noToFind, a, low, mid - 1);
            }
        }


    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int c = in.nextInt();
            int a[] = new int[c];

            for (int j = 0; j < c; j++) {
                a[j] = in.nextInt();

            }

            int key = in.nextInt();


            SearchInARotatedArray rotatedArray = new SearchInARotatedArray();
            int index = rotatedArray.searchInASortedRotatedArray(key, a, 0, a.length - 1);
            System.out.println("" + index);

        }
    }
}

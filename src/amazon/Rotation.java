package amazon;

import java.util.Scanner;

/**
 * Created by sumon.chatterjee on 02/08/17.
 */
public class Rotation {

    public static void main(String[] args) {

        int count = -1;

        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        for (int i = 0; i < t; i++) {

            int c = in.nextInt();
            int a[] = new int[c];

            for (int j = 0; j < c; j++) {
                a[j] = in.nextInt();

                Rotation r = new Rotation();
                count = r.getNoOfRotation(a,0,a.length-1);


            }

            System.out.println("Rotation count is " + count);

        }

    }


    private int getNoOfRotation(int[]a , int start, int end){
        if (start < end) return 0;


        int len = a.length;

        int mid = (start + end) / 2;
        int prev = (mid - 1 + len) % len; //if mid is at 0, consider last element as previous
        int next = (mid + 1) % len;

        if(a[mid] < a[prev]) {
            return mid;
        } else if (a[mid] > a[next]) {
            return next;
        } else if(mid - 1 > start && a[start] <= a[mid - 1] ) {
            return getNoOfRotation(a, mid+1, end);
        } else {
            return getNoOfRotation(a, start, mid-1);
        }
    }


}

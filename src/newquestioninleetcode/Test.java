package newquestioninleetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sumon.chatterjee on 08/12/17.
 */
public class Test {
    void merge(int A[], int m, int B[], int n) {
            while (m > 0 && n > 0) {
                int idx = m + n - 1;
                int va = A[m - 1];
                int vb = B[n - 1];
                if (va > vb) {
                    A[idx] = va;
                    m--;
                } else {
                    A[idx] = vb;
                    n--; }
            }
            while (n > 0) {
                A[n - 1] = B[n - 1];
                n--;
            }
        }







        public class sortedComparetor implements Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2) {
                assert o1!=null && o2!=null;

                return o1-o2;
            }


        }


    public static void main(String[] args) {
        int[][] test = { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;





    }


}

package facebookLeetcode;

import java.util.Stack;

/**
 * Created by sumon.chatterjee on 13/09/18.
 */
public class CelebrityProblem {

    private static boolean knows(int a,int b){
        return true;
    }

    static int findCelebrity(int n)
    {
        Stack<Integer> st = new Stack<>();
        int c;

        // Step 1 :Push everybody
        // onto stack
        for (int i = 0; i < n; i++)
        {
            st.push(i);
        }

        while (st.size() > 1)
        {
            // Step 2 :Pop off top
            // two persons from the
            // stack, discard one
            // person based on return
            // status of knows(A, B).
            int a = st.pop();
            int b = st.pop();

            // Step 3 : Push the
            // remained person onto stack.
            if (knows(a, b))
            {
                st.push(b);
            }

            else
                st.push(a);
        }

        c = st.pop();

        // Step 5 : Check if the last
        // person is celebrity or not
        for (int i = 0; i < n; i++)
        {
            // If any person doesn't
            //  know 'c' or 'a' doesn't
            // know any person, return -1
            if (i != c && (knows(c, i) ||
                    !knows(i, c)))
                return -1;
        }
        return c;
    }

    public int findCelebrityAnotherMethod(int n) {
        if (n <= 1) {
            return -1;
        }

        int left = 0;
        int right = n - 1;

        // Step 1: Find the potential candidate
        while (left < right) {
            if (knows(left, right)) {
                left++;
            } else {
                right--;
            }
        }

        // Step 2: Validate the candidate
        int candidate = right;
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                return -1;
            }
        }

        return candidate;
    }
}

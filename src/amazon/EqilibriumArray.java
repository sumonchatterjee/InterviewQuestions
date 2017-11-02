package amazon;

import java.util.Arrays;

/**
 * Created by sumon.chatterjee on 03/08/17.
 */
public class EqilibriumArray {

    public int getEquilibrium(int[] array) {
        long totalSum = sum(array);
        long lowSum = 0L;
        for (int i = 0; i < array.length; i++) {
            totalSum -= array[i];
            if (lowSum == totalSum) {
                return i;
            }
            lowSum += array[i];
        }
        return -1;
    }

    public long sum(int[] array) {
        return Arrays.stream(array).asLongStream().sum();
    }


    public static void main(String[] args) {
        int a[]= {-1,3,-4,5,1,-6,2,1};

                EqilibriumArray aa = new EqilibriumArray();
                int sum = aa.getEquilibrium(a);
        System.out.println(""+sum);


            }
        }



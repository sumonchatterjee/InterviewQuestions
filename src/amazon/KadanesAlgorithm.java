package amazon;

import java.util.Scanner;

/**
 * Created by sumon.chatterjee on 01/08/17.
 */
public class KadanesAlgorithm {


    // find the maximum sum in the sub array
    private int findMaxSumInASubArray(int a[]){

        int max_so_far,max_ending;
        max_so_far=a[0];
        max_ending=0;


        int length =  a.length;
        for(int i=0;i<length;i++){

            max_ending = max_ending + a[i];
            if(max_so_far < max_ending){
                max_so_far = max_ending ;
            }

            if(max_ending < 0){

                max_ending  = 0 ;
            }


        }

        return max_so_far;


    }

    public static void main(String[] args){


        Scanner in =  new Scanner(System.in);

        int t = in.nextInt();
        for(int i=0;i<t;i++){

          int c = in.nextInt();
          int a[] = new int[c];

          for(int j=0;j<c;j++){
              a[j] = in.nextInt();

          }
           KadanesAlgorithm algorithm =  new KadanesAlgorithm();
           int sum = algorithm.findMaxSumInASubArray(a);


      }

    }
}

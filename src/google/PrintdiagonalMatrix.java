package google;

/**
 * Created by sumon.chatterjee on 07/12/17.
 */
public class PrintdiagonalMatrix {

    public static void main(String[] args) {
        int[][]m={{1,2,3},{2,4,5},{4,4,5}};
        PrintdiagonalMatrix test= new PrintdiagonalMatrix();
        test.printMatrixDiagonalInOnwWay(m);

    }


    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length, arr[] = new int[m * n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = matrix[r][c];
            if ((r + c) % 2 == 0)
            { // moving up
                if      (c == n - 1)
                {
                    r++;
                }
                else if (r == 0)
                {
                    c++;
                }
                else
                    {
                        r--; c++;
                    }
            } else
                {                // moving down
                if      (r == m - 1)
                {
                    c++;
                }
                else if (c == 0)
                {
                    r++;
                }
                else
                    {
                        r++;
                        c--;
                    }
            }
        }
        return arr;
    }



    public void printMatrixDiagonalInOnwWay(int[][] matrix){


                    int row, col;
                        int rowCount = matrix.length;
            	        int columnCount = matrix[0].length;

            	        for (int k = 0; k < rowCount; k++) {
                	            for (row = k, col = 0; row >= 0 && col < columnCount; row--, col++) {
                                    System.out.print(matrix[row][col] + " " );
                                }
                            System.out.println();
                        }

            	        for (int k = 1; k < columnCount; k++) {
                	            for (row = rowCount - 1, col = k; row >= 0 && col < columnCount; row--, col++) {
                                    System.out.print(matrix[row][col] + " " );
                                }
                            System.out.println();
                	        }
            	    }



}

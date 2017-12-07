package google;

/**
 * Created by sumon.chatterjee on 28/11/17.
 */
public class SquareRotationOfmatrixInplace {

    //matrix print in anticlockwise direction

    void rotateMatrix(int[][] mat)
    {
        int n= mat.length;
        // Consider all squares one by one
        for (int x = 0; x < n / 2; x++)     //how many circles are there in the matrix. consider 4 element fo the circle
        {
            // Consider elements in group of 4 in
            // current square
            for (int y = x; y < n-x-1; y++)
            {
                // store current cell in temp variable
                int temp = mat[x][y];

                // move values from right to top
                mat[x][y] = mat[y][n-1-x];

                // move values from bottom to right
                mat[y][n-1-x] = mat[n-1-x][n-1-y];

                // move values from left to bottom
                mat[n-1-x][n-1-y] = mat[n-1-y][x];

                // assign temp to left
                mat[n-1-y][x] = temp;
            }
        }
    }


    // Function to print the matrix
    void displayMatrix(int[][] mat)
    {
        int n= mat.length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
                System.out.print(mat[i][j]+ " ");

            System.out.println();
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int [][]mat =
        {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        SquareRotationOfmatrixInplace mats = new SquareRotationOfmatrixInplace();
        mats.rotateMatrix(mat);
        mats.displayMatrix(mat);



    }
}

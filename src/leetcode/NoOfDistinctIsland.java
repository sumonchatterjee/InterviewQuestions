package leetcode;

/**
 * Created by sumon.chatterjee on 21/11/17.
 */

/*http://www.geeksforgeeks.org/find-number-of-islands/*/
public class NoOfDistinctIsland {

    private final int[] xDir = {1,  0, -1, 0};
    private final int[] yDir = {0, -1,  0, 1}; // arrays for getting up, left ,right, down for a matrix point

    // (1,0) -  right
    // (0,-1) - left
    // (-1,0) - down
    // (0,1)  - up     in graph axis

    public int numIslands(char[][] grid) {
       if (grid == null || grid.length == 0 ||grid[0].length==0)
           return 0;

       int row = grid.length;
       int column = grid[0].length;
       boolean[][]visited = new boolean[row][column];
       int result =0;


       for(int i=0;i<row;i++){
           for(int j=0;j<column;j++){
               if ((grid[i][j]=='0') || (visited[i][j])){ // if grid element is 0 or if it is already visited then don't visit that element
                           continue;
               }

               this.explore(i,j,row,column,grid,visited);
               result++;
           }
       }
       return result;
    }



    private void explore(int x, int y, int row, int col,char[][]grid,boolean[][]visited){
    if(!shouldExplore(x,y,row,col,grid,visited))
    return;

    visited[x][y]=true;

    for(int i = 0 ;i < 4;i ++){
        this.explore(x+xDir[i], y+yDir[i],row, col, grid,visited);

    }

    }



    private boolean shouldExplore(int x, int y, int row, int col,char[][]grid,boolean[][]visited){
       if (x >= 0 && x < row && y >=0 && y< col && grid[x][y]== '1' && !visited[x][y]) {
           return true;
       }


       return false;
    }
}

package google;

/**
 * Created by sumon.chatterjee on 30/12/17.
 */
public class WordSearch1 {

    private boolean searchWord(char[][] board,String word){

        if(word==null || board.length==0 ||board[0].length==0) return false;

        int row= board.length;
        int coloumn= board[0].length;

        boolean[][] visited = new boolean[row][coloumn];

        for(int i=0;i<row;i++){
            for(int j=0;j<coloumn;j++){
                if(helper(board,0,i,j,visited,word))
                    return true;
            }
        }

        return false;

    }



    private boolean helper(char[][]board,int index, int row,int coloumn,boolean[][]visited,String word){
     if(index == word.length())
         return true;

     if(row<0 || row<board.length || coloumn<0 || coloumn<board[0].length)
         return false;

     if(visited[row][coloumn] || word.charAt(index)!=board[row][coloumn])
         return false;

     visited[row][coloumn]=true;

   boolean shouldexplore=helper(board,index+1,row+1,coloumn,visited,word)||
           helper(board,index+1,row,coloumn-1,visited,word)||
           helper(board,index+1,row-1,coloumn,visited,word)||
           helper(board,index+1,row,coloumn+1,visited,word);

   visited[row][coloumn]=false;





    return shouldexplore;
    }

}

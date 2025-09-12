// Last updated: 13/09/2025, 01:48:08
class Solution {
    public static void dfs(int[][]board,int[][] visited,int i,int j){
        visited[i][j]=1;
        int[]dirow={-1,0,1,0};
        int[]dicol={0,1,0,-1};
        int n = board.length;
        int m = board[0].length;
        for(int z = 0;z<4;z++) {
            int nrow = i + dirow[z];
            int ncol = j + dicol[z]; 
            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m 
            && visited[nrow][ncol] == 0 && board[nrow][ncol] == 1) {
                dfs(board,visited,nrow,ncol); 
            }
        }
    }
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] visited=new int[board.length][board[0].length];
        for(int j=0;j<board[0].length;j++){
            if(visited[0][j]!=1 && board[0][j]==1){
                dfs(board,visited,0,j);
            }
            if(visited[board.length-1][j]!=1 && board[board.length-1][j]==1){
                dfs(board,visited,board.length-1,j);
            }
        }
        for(int i=0;i<board.length;i++){
            if(visited[i][0]!=1 && board[i][0]==1){
                dfs(board,visited,i,0);
            }
            if(visited[i][board[0].length-1]!=1 && board[i][board[0].length-1]==1){
                dfs(board,visited,i,board[0].length-1);
            }
        }
        int count=0;
         for(int i = 1;i<n-1;i++) {
            for(int j= 1 ;j<m-1;j++) {
                if(visited[i][j] == 0 && board[i][j] == 1) 
                    count++; 
            }
        }
        return count;
    }
}
    
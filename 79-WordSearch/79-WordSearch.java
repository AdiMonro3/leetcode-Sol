// Last updated: 12/09/2025, 15:02:35
class Solution {
public boolean isValid(int row,int col ,char[][] board){
        return (row<board.length && row>=0 && col<board[0].length && col>=0);
    }
public boolean dfs(char[][] board, String word,int row ,int col,int idx,boolean[][] visited){   
        if(board[row][col]!=word.charAt(idx)) return false;    
        if(idx==word.length()-1) return true;
        
        visited[row][col]=true;
        int[] Row={-1,0,1,0};
        int[] Col={0,1,0,-1};
        for(int k=0;k<4;k++){
            int newr=row+Row[k];
            int newc=col+Col[k];
            if(isValid(newr,newc,board) && !visited[newr][newc]){
               if(dfs(board,word,newr,newc,idx+1,visited)) return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
      for(int i=0;i<board.length;i++){
        for(int j=0;j<board[0].length;j++){
            if(dfs(board,word,i,j,0,visited)) return true;
               
            }
        }
        return false;
    }
}
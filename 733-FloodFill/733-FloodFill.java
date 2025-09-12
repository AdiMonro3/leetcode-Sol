// Last updated: 13/09/2025, 01:48:46
class Solution {
     public class pair{
        int val;
        int row;
        int col;

        public pair(int val,int row,int col){
            this.val=val;
            this.row=row;
            this.col=col;
        }

    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int color) { 
        if(grid[sr][sc]==color) return grid;
        int original=grid[sr][sc];
        Queue<pair> q=new LinkedList<>();
        grid[sr][sc]=color;
        q.offer(new pair(grid[sr][sc],sr,sc));
    
        while(!q.isEmpty()){
           int size=q.size();
           for(int z=0;z<size;z++){
                pair x=q.poll();
                int i=x.row;
                int j=x.col;
                if(i-1>=0){
                    if(grid[i-1][j]==original){
                        q.offer(new pair(grid[i-1][j],i-1,j));
                        grid[i-1][j]=color;
                    }
                }
                if(j-1>=0){
                     if(grid[i][j-1]==original){
                        q.offer(new pair(grid[i][j-1],i,j-1));
                        grid[i][j-1]=color;
                    }
                }
                if(i+1<grid.length){
                     if(grid[i+1][j]==original){
                        q.offer(new pair(grid[i+1][j],i+1,j));
                        grid[i+1][j]=color;
                    }
                }
                if(j+1<grid[0].length){
                     if(grid[i][j+1]==original){
                        q.offer(new pair(grid[i][j+1],i,j+1));
                        grid[i][j+1]=color;
                    }
                }
            }

        }
        return grid;
    }
}
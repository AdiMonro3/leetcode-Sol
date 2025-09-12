// Last updated: 13/09/2025, 01:48:13
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
    public int orangesRotting(int[][] grid) {
    boolean allZero = true;
    for (int i = 0; i < grid.length; i++){
        for (int j = 0; j < grid[0].length; j++){
            if (grid[i][j] != 0) {
                allZero = false;
                break;
            }
        }
        if (!allZero) break;
    }
    if (allZero) return 0;
        int minutes=0;
        Queue<pair> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                        q.offer(new pair(2,i,j));
                    }
                }
            }
        
        if(q.isEmpty()) return -1;
        while(!q.isEmpty()){
           int size=q.size();
           for(int z=0;z<size;z++){
                pair x=q.poll();
                int i=x.row;
                int j=x.col;
                if(i-1>=0){
                    if(grid[i-1][j]!=2 && grid[i-1][j]!=0){
                        q.offer(new pair(grid[i-1][j],i-1,j));
                        grid[i-1][j]=2;
                    }
                }
                if(j-1>=0){
                     if(grid[i][j-1]!=2 && grid[i][j-1]!=0){
                        q.offer(new pair(grid[i][j-1],i,j-1));
                        grid[i][j-1]=2;
                    }
                }
                if(i+1<grid.length){
                     if(grid[i+1][j]!=2 && grid[i+1][j]!=0){
                        q.offer(new pair(grid[i+1][j],i+1,j));
                        grid[i+1][j]=2;
                    }
                }
                if(j+1<grid[0].length){
                     if(grid[i][j+1]!=2 && grid[i][j+1]!=0){
                        q.offer(new pair(grid[i][j+1],i,j+1));
                        grid[i][j+1]=2;
                    }
                }
           }
           minutes++;

        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return minutes-1;
    }
}
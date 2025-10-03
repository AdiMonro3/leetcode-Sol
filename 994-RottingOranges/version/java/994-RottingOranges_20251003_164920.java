// Last updated: 03/10/2025, 16:49:20
class Solution {
    class Pair{
        int node;
        int row;
        int col;
        public Pair(int node,int row,int col){
            this.node=node;
            this.row=row;
            this.col=col;
        }
    }
    public boolean isValid(int row,int col,int m,int n){
        return row>=0 && row<m && col>=0 && col<n;
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(2,i,j));
                }else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int count=0;
        int []row={-1,0,1,0};
        int []col={0,1,0,-1};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int Row=p.row;
                int Col=p.col;
                for(int j=0;j<4;j++){
                    int nrow=Row+row[j];
                    int ncol=Col+col[j];
                    if(isValid(nrow,ncol,m,n) && grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        fresh--;
                        q.add(new Pair(grid[nrow][ncol],nrow,ncol));
                    }
                }
            }
            count++;
        }
        return (fresh == 0) ? count-1 : -1;
    }
}
// Last updated: 06/10/2025, 19:27:24
class Solution {
    class Pair{
        int ht;
        int row;
        int col;
        public Pair(int ht,int row,int col){
            this.ht=ht;
            this.row=row;
            this.col=col;
        }
    }
    public boolean isValid(int newrow,int newcol,int n,int m){
        return newrow>=0 && newrow<n && newcol>=0 && newcol<m;
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean [][] visited=new boolean[n][m];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a, b) -> a.ht - b.ht);
        pq.add(new Pair(grid[0][0],0,0));
        visited[0][0]=true;
        int minTime=grid[0][0];
        int[] rowArr={-1,0,1,0};
        int [] colArr={0,1,0,-1};
        while(!pq.isEmpty()){
            Pair temp=pq.poll();
            int ht=temp.ht;
            int row=temp.row;
            int col=temp.col;
            minTime = Math.max(minTime, ht);
            if (row == n - 1 && col == m - 1) {
                return minTime; 
            }
            for(int i=0;i<4;i++){
                int newRow=row+rowArr[i];
                int newCol=col+colArr[i];
                if(isValid(newRow,newCol,n,m) && !visited[newRow][newCol]){
                    pq.add(new Pair(grid[newRow][newCol],newRow,newCol));
                    visited[newRow][newCol]=true;
                }
            }
        }
        return -1;
    }
}
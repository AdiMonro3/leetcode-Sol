// Last updated: 13/09/2025, 01:48:04
class Solution {
    class pair{
        int row;
        int col;
        int dist;
        pair(int row, int col, int dist){
            this.row=row;
            this.col=col;
            this.dist=dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0 || grid[n-1][n-1]!=0) return -1;
        int[][] dir={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        Queue<pair> q=new LinkedList<>();
        boolean [][] visited=new boolean[n][grid[0].length];
        q.add(new pair(0,0,1));
        visited[0][0] = true;
        while(!q.isEmpty()){
            pair p=q.poll();
            int r=p.row;
            int c=p.col;
            int d=p.dist;
            if (r == n - 1 && c == n - 1) return d;

            for(int[] it:dir){
                int newRow = r + it[0];
                int newCol = c + it[1];
                if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n &&
                        grid[newRow][newCol] == 0 && !visited[newRow][newCol]){
                            visited[newRow][newCol] = true;
                            q.add(new pair(newRow,newCol,d+1));
                        }
            }
        }
        return -1;
    }
}
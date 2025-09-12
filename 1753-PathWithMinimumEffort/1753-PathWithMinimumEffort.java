// Last updated: 13/09/2025, 01:47:41
class Solution {
    class pair{
        int diff;
        int row;
        int col;
        pair(int diff,int row,int col){
            this.diff=diff;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int direction[][]={{-1,0},{0,1},{1,0},{0,-1}};
        int dist[][]=new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0]=0;
        PriorityQueue<pair> q = new PriorityQueue<>((a, b) -> a.diff - b.diff);
        q.add(new pair(0,0,0));
        while(!q.isEmpty()){
            pair p=q.poll();
            int row=p.row;
            int col=p.col;
            int currdiff=p.diff;
            if(row==n-1 && col==m-1) return currdiff;
            for (int[] dir : direction) {
                int nx = row + dir[0], ny = col + dir[1];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m){
                    int nextEffort = Math.max(currdiff, Math.abs(heights[row][col] - heights[nx][ny]));

                    // only update if we found a better (smaller) effort
                    if (nextEffort < dist[nx][ny]) {
                        dist[nx][ny] = nextEffort;
                        q.add(new pair(nextEffort, nx, ny));
                    }
                }

        }

    }
    return 0;
    }
}
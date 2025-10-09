// Last updated: 09/10/2025, 23:12:10
class Solution {
    public class Pair{
        long max;
        long min;
        public Pair(long max,long min){
            this.max=max;
            this.min=min;
        }
    }
    Pair[][] dp;
    public Pair helper(int[][] grid,int n,int m,int i,int j){
        if(i==n-1 && j==m-1) return new Pair(grid[i][j],grid[i][j]);
        if(i>=n || j>=m) return  new Pair(Long.MIN_VALUE, Long.MIN_VALUE);
        if (dp[i][j] != null)
            return dp[i][j];

        Pair down=helper(grid,n,m,i+1,j);
        Pair right=helper(grid,n,m,i,j+1);

        long curr=grid[i][j];
        long minVal=Integer.MAX_VALUE;
        long maxVal=Integer.MIN_VALUE;

        if (right.max != Long.MIN_VALUE) {
            long rmax = curr * right.max;
            long rmin = curr * right.min;
            maxVal = Math.max(maxVal, Math.max(rmax, rmin));
            minVal = Math.min(minVal, Math.min(rmax, rmin));
        }

        // Down path contribution
        if (down.max != Long.MIN_VALUE) {
            long dmax = curr * down.max;
            long dmin = curr * down.min;
            maxVal = Math.max(maxVal, Math.max(dmax, dmin));
            minVal = Math.min(minVal, Math.min(dmax, dmin));
        }

        dp[i][j] = new Pair(maxVal, minVal);
        return dp[i][j];

    }
    public int maxProductPath(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        dp = new Pair[n][m];
        Pair result = helper(grid, n, m, 0, 0);
        if (result.max < 0) return -1;
        return (int) (result.max % 1000000007);
    }
}
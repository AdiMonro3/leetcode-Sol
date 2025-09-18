// Last updated: 18/09/2025, 11:51:01
class Solution {
    //memoiation
    public int helper(int m,int n,int row,int col, int dp[][]){
        if(row==m-1 && col==n-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        int pickRow = 0, pickCol = 0;
       
        if(row<m-1){
             pickRow=helper(m,n,row+1,col,dp);
        }
        if(col<n-1){
             pickCol=helper(m,n,row,col+1,dp);
        }
        return dp[row][col]=pickRow+pickCol;
    }
    public int uniquePaths(int m, int n) {
        // tabulation
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1; // base case

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) continue;

                int down = (i + 1 < m) ? dp[i + 1][j] : 0;
                int right = (j + 1 < n) ? dp[i][j + 1] : 0;

                    dp[i][j] = down + right;
                }
            }
            return dp[0][0];
    }
}
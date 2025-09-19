// Last updated: 19/09/2025, 21:54:49
class Solution {
    public int helper(int n,int m,int [][] matrix,int row,int col,int [][] dp){
        if(col<0 || col>=m) return Integer.MAX_VALUE;
        if(row==n-1) return dp[row][col]=matrix[row][col];
        if(dp[row][col]!=-1) return dp[row][col];

        int leftd=helper(n,m,matrix,row+1,col-1,dp);
        int center=helper(n,m,matrix,row+1,col,dp);
        int rightd=helper(n,m,matrix,row+1,col+1,dp);

        return dp[row][col]=matrix[row][col]+Math.min(leftd,Math.min(center,rightd));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int [][] dp=new int[n][m];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // int ans=Integer.MAX_VALUE;
        // for(int i=0;i<m;i++){
        //      ans=Math.min(ans,helper(n,m,matrix,0,i,dp));
        // }
        // return ans;

         for (int j = 0; j < m; j++) {
            dp[n - 1][j] = matrix[n - 1][j];
        }

        // Build the DP table from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int left = j > 0 ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int down = dp[i + 1][j];
                int right = j < m - 1 ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(left, right));
            }
        }

        // The answer is the min value in the top row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[0][j]);
        }

        return ans;
    }
}
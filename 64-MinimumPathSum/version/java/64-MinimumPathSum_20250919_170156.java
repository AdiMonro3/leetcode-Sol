// Last updated: 19/09/2025, 17:01:56
class Solution {
    public int helper(int n,int m, int[][] grid,int row ,int col,int [][]dp){
        if(row==n-1 && col==m-1) return grid[row][col];
        if(row<0 || row>=n || col<0 || col>=m) return Integer.MAX_VALUE;
        if(dp[row][col]!=-1) return dp[row][col];

        int pickr=0;
        int pickc=0;
        pickr=helper(n,m,grid,row+1,col,dp);
        pickc=helper(n,m,grid,row,col+1,dp);
      
        return dp[row][col]=grid[row][col]+ Math.min(pickr,pickc);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        dp[0][0]=grid[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) continue;
                int pickr=Integer.MAX_VALUE;
                int pickc=Integer.MAX_VALUE;
                if(i>0){
                    pickr=dp[i-1][j];
                }
                if(j>0){
                    pickc=dp[i][j-1];
                }
                dp[i][j]=grid[i][j]+Math.min(pickr,pickc);
            }
        }
        return dp[n-1][m-1];
    }
}
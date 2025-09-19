// Last updated: 19/09/2025, 16:50:43
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
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(n,m,grid,0,0,dp);
    }
}
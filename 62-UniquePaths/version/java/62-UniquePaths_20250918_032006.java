// Last updated: 18/09/2025, 03:20:06
class Solution {
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
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }

        }
        return helper(m,n,0,0,dp);
    }
}
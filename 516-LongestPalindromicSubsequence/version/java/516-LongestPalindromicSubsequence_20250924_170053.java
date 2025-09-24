// Last updated: 24/09/2025, 17:00:53
class Solution {
    // memoization
    public int lps(String s1,String s2,int i,int j,int [][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]= 1+lps(s1,s2,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(lps(s1,s2,i-1,j,dp),lps(s1,s2,i,j-1,dp));
    }
    public int longestPalindromeSubseq(String s) {
         String s2 = new StringBuilder(s).reverse().toString();
         int n=s.length();
         int dp[][]=new int[n+1][n+1];
        
         for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]= 1+dp[i-1][j-1];
                }
                else{ 
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}
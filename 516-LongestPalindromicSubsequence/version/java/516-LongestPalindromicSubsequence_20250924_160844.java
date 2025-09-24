// Last updated: 24/09/2025, 16:08:44
class Solution {
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
         int dp[][]=new int[n][n];
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
         }
         return lps(s,s2,n-1,n-1,dp);
    }
}
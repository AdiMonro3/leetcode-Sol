// Last updated: 13/09/2025, 01:49:13
class Solution {
    // public static int lps(String s1,String s2,int i,int j,int dp[][]){
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         return dp[i][j]=1+lps(s1,s2,i-1,j-1,dp);
    //     }
    //     return dp[i][j]=Math.max(lps(s1,s2,i-1,j,dp),lps(s1,s2,i,j-1,dp));
    // }
    public int longestPalindromeSubseq(String s1) {
         String s2 = new StringBuilder(s1).reverse().toString();
        // int dp[][]=new int [s1.length()][s2.length()];
        // for(int i=0;i<s1.length();i++){
        //     for(int j=0;j<s2.length();j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return lps(s,s2,s.length()-1,s2.length()-1,dp);
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
        
    }
}
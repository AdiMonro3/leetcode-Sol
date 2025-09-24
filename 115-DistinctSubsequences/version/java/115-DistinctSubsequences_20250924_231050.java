// Last updated: 24/09/2025, 23:10:50
class Solution {
    public int helper(String s1,String s2,int i,int j,int [][] dp){
        if(j<0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int count=0;
        if(s1.charAt(i)==s2.charAt(j)){
            count+=helper(s1,s2,i-1,j-1,dp);
        }
        count+=helper(s1,s2,i-1,j,dp);
        return dp[i][j]=count;

    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int [][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                 int count=0;
                if(s.charAt(i-1)==t.charAt(j-1)){
                    count+=dp[i-1][j-1];
                }
                count+=dp[i-1][j];
                dp[i][j]=count;
            }
        }
        return dp[n][m];

    }
}
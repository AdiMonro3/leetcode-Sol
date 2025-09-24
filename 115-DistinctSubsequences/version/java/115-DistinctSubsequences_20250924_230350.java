// Last updated: 24/09/2025, 23:03:50
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
        int [][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        return helper(s,t,s.length()-1,t.length()-1,dp);
    }
}
// Last updated: 22/11/2025, 01:04:04
class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        boolean dp[][]=new boolean[n][n];
        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;
                if(i==j){
                    dp[i][j]=true;
                }
                else if(i+1==j){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }
                }else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }
                if(dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
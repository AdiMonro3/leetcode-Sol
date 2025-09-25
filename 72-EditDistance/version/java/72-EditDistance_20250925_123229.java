// Last updated: 25/09/2025, 12:32:29
class Solution {
    public int helper(String s1,String s2,int i,int j, int[][] dp){
        if(i<0){
            return j+1;//insert j elements
        }
        if(j<0){
            return i+1;//delete i elements
        }
        if (dp[i][j] != -1) return dp[i][j];
        int count=0;
        if(s1.charAt(i)==s2.charAt(j)){
            count+=helper(s1,s2,i-1,j-1,dp);
        }else{
            count+=Math.min(1+helper(s1,s2,i-1,j,dp),Math.min(1+helper(s1,s2,i,j-1,dp),1+helper(s1,s2,i-1,j-1,dp)));
        }
        return dp[i][j]=count;
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = i; // delete all
        for (int j = 0; j <= m; j++) dp[0][j] = j; // insert all

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1],Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
    }

    return dp[n][m];
    }
}
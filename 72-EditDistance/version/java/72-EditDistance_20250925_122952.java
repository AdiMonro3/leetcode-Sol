// Last updated: 25/09/2025, 12:29:52
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
        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(word1,word2,n-1,m-1,dp);
    }
}
// Last updated: 13/09/2025, 01:48:03
class Solution {
    // rdcursion and memoization
    public static int lcs(String text1,String text2,int i,int j,int dp[][]){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)){
            return  dp[i][j]=1+lcs(text1,text2,i-1,j-1,dp);
        }
        return dp[i][j]=Math.max(lcs(text1,text2,i-1,j,dp),lcs(text1,text2,i,j-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
    //     int [][]dp= new int[text1.length()][text2.length()];
    //    for (int[] row : dp) {
    //      Arrays.fill(row, -1);
    //     }
    //     return lcs(text1,text2,text1.length()-1,text2.length()-1, dp);

    // tabulation approach
    int i=text1.length();
    int j=text2.length();
    int dp[][]= new int [i+1][j+1];
    for(int row=1;row<i+1;row++){
        for(int col=1;col<j+1;col++){
             if(text1.charAt(row-1)==text2.charAt(col-1)){
                dp[row][col]=1+dp[row-1][col-1];
             }
             else dp[row][col]=Math.max(dp[row-1][col],dp[row][col-1]);
        }
    }
    return dp[i][j];
    }
}
// Last updated: 02/02/2026, 20:01:56
1class Solution {
2    // rdcursion and memoization
3    public static int lcs(String text1,String text2,int i,int j,int dp[][]){
4        if(i<0 || j<0) return 0;
5
6        if(dp[i][j]!=-1) return dp[i][j];
7        if(text1.charAt(i)==text2.charAt(j)){
8            return  dp[i][j]=1+lcs(text1,text2,i-1,j-1,dp);
9        }
10        return dp[i][j]=Math.max(lcs(text1,text2,i-1,j,dp),lcs(text1,text2,i,j-1,dp));
11    }
12    public int longestCommonSubsequence(String text1, String text2) {
13    //     int [][]dp= new int[text1.length()][text2.length()];
14    //    for (int[] row : dp) {
15    //      Arrays.fill(row, -1);
16    //     }
17    //     return lcs(text1,text2,text1.length()-1,text2.length()-1, dp);
18
19    // tabulation approach
20    int i=text1.length();
21    int j=text2.length();
22    int dp[][]= new int [i+1][j+1];
23    for(int row=1;row<i+1;row++){
24        for(int col=1;col<j+1;col++){
25             if(text1.charAt(row-1)==text2.charAt(col-1)){
26                dp[row][col]=1+dp[row-1][col-1];
27             }
28             else dp[row][col]=Math.max(dp[row-1][col],dp[row][col-1]);
29        }
30    }
31    return dp[i][j];
32    }
33}
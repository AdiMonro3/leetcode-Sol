// Last updated: 13/08/2026, 19:07:58
1class Solution {
2    int[][] dp;
3    public int helper(int[]piles ,int i ,int j){
4        if(i>j){
5            return 0;
6        }
7        if(dp[i][j]!=-1) return dp[i][j];
8        int pick_i=piles[i]+Math.min(helper(piles,i+1,j-1),helper(piles,i+2,j));
9        int pick_j=piles[j]+Math.min(helper(piles,i+1,j-1),helper(piles,i,j-2));
10
11        return dp[i][j]=Math.max(pick_i,pick_j);
12    }
13    public boolean stoneGame(int[] piles) {
14        int n = piles.length;
15        // int[][] dp = new int[n][n];
16        // for (int i = 0; i < n; i++) dp[i][i] = piles[i];
17        // for (int len = 2; len <= n; len++){
18        //     for (int i = 0; i + len - 1 < n; i++) {
19        //     int j = i + len - 1;
20        //     dp[i][j] = Math.max(piles[i] - dp[i + 1][j],
21        //                     piles[j] - dp[i][j - 1]);
22        //     }
23        // }
24
25    // return dp[0][n - 1] > 0;
26        dp=new int[n][n];
27        for(int i=0;i<n;i++){
28            Arrays.fill(dp[i],-1);
29        }
30        int sum=0;
31        for(int i=0;i<n;i++) sum+=piles[i];
32
33        boolean result=false;
34        int temp=helper(piles,0,n-1);
35        if(temp>sum-temp){
36            result=true;
37        }
38
39        return result;
40        
41    }
42}
// Last updated: 17/10/2025, 22:46:35
class Solution {
     int MOD = 1_000_000_007;
     int [][] dp;
    public int helper(int num,int curr,int x){
        if(num==0) return 1;
        long pow=(long)Math.pow(curr,x);
        if(pow>num) return 0;
        if (dp[num][curr] != -1) return dp[num][curr];

        int pick=helper(num-(int)pow,curr+1,x);
        int notpick=helper(num,curr+1,x);

        return dp[num][curr] = (int)((pick + notpick) % MOD);
    }
    public int numberOfWays(int n, int x) {
         dp = new int[n + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(n,1,x);
    }
}
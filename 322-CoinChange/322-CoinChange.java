// Last updated: 13/09/2025, 01:50:02
class Solution {
    public static int minimum(int []coins,int amt,int n,int[][] dp){
        if(n==0){
            if(amt%coins[0]==0){
                return amt/coins[0];
            }
            else return (int) Math.pow(10, 9);
        }
        if (dp[n][amt] != -1)
            return dp[n][amt];

        int notpick=0+minimum(coins,amt,n-1,dp);
        int pick=(int) Math.pow(10, 9);
        if(coins[n]<=amt){
            pick=1+minimum(coins,amt-coins[n],n,dp);
        }
        return dp[n][amt] = Math.min(notpick, pick);
    }
    
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<=amount;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                dp[1][i]=i/coins[0];   
        }
            else dp[1][i]=Integer.MAX_VALUE-1;
    }
        for(int ind=2;ind<=coins.length;ind++){
            for(int amt=1;amt<=amount;amt++){
                int notpick=0+dp[ind-1][amt];
                int pick=Integer.MAX_VALUE-1;
                if(coins[ind-1]<=amt){
                    pick=1+dp[ind][amt-coins[ind-1]];
                }
                dp[ind][amt]=Math.min(pick,notpick);
            }
        }
        int ans=dp[coins.length][amount];
        if (ans >= Integer.MAX_VALUE-1){
            return -1;
        }
        return ans;
    }
}
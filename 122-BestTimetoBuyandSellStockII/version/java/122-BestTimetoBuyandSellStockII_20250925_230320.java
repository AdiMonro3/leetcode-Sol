// Last updated: 25/09/2025, 23:03:20
class Solution {
    public int helper(int [] prices,int n,int buy,int idx,int [][]dp){
        if(idx>=n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==0){
            profit=Math.max(-prices[idx]+helper(prices,n,1,idx+1,dp),helper(prices,n,0,idx+1,dp));
        }else{
            profit=Math.max(prices[idx]+helper(prices,n,0,idx+1,dp),helper(prices,n,1,idx+1,dp));
        }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            dp[i][0]=-1;
            dp[i][1]=-1;
        }
        return helper(prices,prices.length,0,0,dp);
    }
}
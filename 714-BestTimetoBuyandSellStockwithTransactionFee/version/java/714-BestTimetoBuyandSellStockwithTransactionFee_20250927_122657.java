// Last updated: 27/09/2025, 12:26:57
class Solution {
     public int helper(int [] arr,int n,int idx,int buy,int dp[][],int fees){
        if(idx>=n) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(-arr[idx]+helper(arr,n,idx+1,0,dp,fees),helper(arr,n,idx+1,1,dp,fees));
        }else{
            profit=Math.max(arr[idx]-fees+helper(arr,n,idx+1,1,dp,fees),helper(arr,n,idx+1,0,dp,fees));
        }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
         int n=prices.length;
        int [][]dp=new int [n+1][2];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<2;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return helper(prices,n,0,1,dp,fee);
        for(int idx=n-1;idx>=0;idx--){
            for(int buy=0;buy<=1;buy++){
                int profit=0;
                if(buy==1){
                    profit=Math.max(-prices[idx]+dp[idx+1][0],dp[idx+1][1]);
                }else{
                    profit=Math.max(prices[idx]-fee+dp[idx+1][1],dp[idx+1][0]);
                }
                dp[idx][buy]=profit;
            }
        }
        return dp[0][1];
    }
}
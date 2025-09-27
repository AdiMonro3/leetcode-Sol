// Last updated: 27/09/2025, 11:53:21
class Solution {
    public int helper(int [] arr,int n,int idx,int buy,int cap,int dp[][][]){
        if(idx>=n) return 0;
        if(cap==0) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        int profit=0;
        if(buy==1){
            profit=Math.max(-arr[idx]+helper(arr,n,idx+1,0,cap,dp),helper(arr,n,idx+1,1,cap,dp));
        }else{
            profit=Math.max(arr[idx]+helper(arr,n,idx+1,1,cap-1,dp),helper(arr,n,idx+1,0,cap,dp));
        }
        return dp[idx][buy][cap]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][][] dp=new int [n+1][2][3];
       for(int idx=n-1;idx>=0;idx--){
            for(int j=0;j<=1;j++){
                for(int k=1;k<=2;k++){
                    int profit=0;
                    if(j==1){
                        profit=Math.max(-prices[idx]+dp[idx+1][0][k],dp[idx+1][1][k]);
                    }else{
                        profit=Math.max(prices[idx]+dp[idx+1][1][k-1],dp[idx+1][0][k]);
                    }
                    dp[idx][j][k]=profit;
                }
            }
        }
        return dp[0][1][2];
    }
}
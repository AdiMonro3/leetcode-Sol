// Last updated: 27/09/2025, 11:31:00
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
        int [][][] dp=new int [n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return helper(prices,n,0,1,2,dp);
    }
}
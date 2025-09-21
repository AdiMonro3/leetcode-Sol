// Last updated: 21/09/2025, 14:14:09
class Solution {
    public int helper(int n,int []nums,int idx,int previdx,int [][] dp){
        if(idx==n){
            return 0;
        }
        if(dp[idx][previdx+1]!=-1) return dp[idx][previdx+1];
        int pick=0;
        if(previdx==-1 || nums[idx]>nums[previdx]){
            pick=1+helper(n,nums,idx+1,idx,dp);
        }
        int notpick=helper(n,nums,idx+1,previdx,dp);

        return   dp[idx][previdx+1]=Math.max(pick,notpick);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int [][] dp=new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n+1;j++){
            dp[i][j]=-1;
            }
        }
        return helper(n,nums,0,-1,dp);
    }
}
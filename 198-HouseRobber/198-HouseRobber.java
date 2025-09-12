// Last updated: 13/09/2025, 01:50:53
class Solution {
    public static int helper(int[] nums,int index,int[] dp){
        if(index==0) return nums[index];
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int pick=nums[index]+helper(nums,index-2,dp);
        int nonpick=0+helper(nums,index-1,dp);

        return dp[index]=Math.max(pick,nonpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,n-1,dp);
        
    }
}
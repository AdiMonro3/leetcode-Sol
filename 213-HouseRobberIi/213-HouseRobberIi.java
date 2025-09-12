// Last updated: 13/09/2025, 01:50:39
class Solution {
    public static int helper(int [] nums,int start,int end,int [] dp){
        if(start<end) return 0;
        if(dp[start]!=-1) return dp[start];

        int pick=nums[start]+helper(nums,start-2,end,dp);
        int nonpick=0+helper(nums,start-1,end,dp);

        return  dp[start]=Math.max(pick,nonpick);
    }
    public int rob(int[] nums) {
        int n= nums.length;
        int [] dp1 =new int[n];
        int [] dp2 =new int[n];
        Arrays.fill(dp1,-1);
         Arrays.fill(dp2,-1);
        if(n==1) return nums[0];

        int first=helper(nums,n-1,1,dp1);
        int second=helper(nums,n-2,0,dp2);

        return Math.max(first,second);
    }
    
}
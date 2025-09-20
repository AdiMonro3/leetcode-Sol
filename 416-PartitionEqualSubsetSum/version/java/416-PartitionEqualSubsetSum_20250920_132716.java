// Last updated: 20/09/2025, 13:27:16
class Solution {
    public boolean helper(int idx, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (idx == nums.length || target < 0) return false;

        if (dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean pick = false;
        if (nums[idx] <= target) {
            pick = helper(idx + 1, target - nums[idx], nums, dp);
        }
        boolean notPick = helper(idx + 1, target, nums, dp);

        dp[idx][target] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        // Cannot partition if total sum is odd
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        boolean[][] dp = new boolean[n+1][target + 1];

        for(int i=0;i<n+1;i++){
          dp[i][0]=true;
        }
        for(int j=1;j<dp[0].length;j++){
         
          dp[0][j]=false;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<dp[0].length;j++){
                boolean pick=false;
                boolean notpick=false;
                if(nums[i-1]<=j){
                    pick=dp[i-1][j-nums[i-1]];
                }
                    notpick=dp[i-1][j];
                    dp[i][j]=pick||notpick;
            }
        }
        return dp[n][target];

       
    }
}

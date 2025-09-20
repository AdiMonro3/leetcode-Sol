// Last updated: 20/09/2025, 13:23:16
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
        int sum = 0;
        for (int num : nums) sum += num;

        // Cannot partition if total sum is odd
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return helper(0, target, nums, dp);
    }
}

// Last updated: 18/10/2025, 16:32:41
class Solution {
    private int n;
    private int[][][] memo;

    private int solve(int[] nums, int k, int i, int op1, int op2) {
        // Base Case
        if (i == n) {
            return 0;
        }
        if (memo[i][op1][op2] != -1) {
            return memo[i][op1][op2];
        }
        int result = Integer.MAX_VALUE; // minimum sum

        // Apply op1
        if (op1 > 0) {
            int newVal = (nums[i] + 1) / 2; // ceil(nums[i] / 2.0)
            int applyOp1 = newVal + solve(nums, k, i + 1, op1 - 1, op2);
            result = Math.min(result, applyOp1);
        }

        // Apply op2
        if (op2 > 0 && nums[i] >= k) {
            int newVal = nums[i] - k;
            int applyOp2 = newVal + solve(nums, k, i + 1, op1, op2 - 1);
            result = Math.min(result, applyOp2);
        }

        // Apply both op1 -> op2
        if (op1 > 0 && op2 > 0) {
            int newVal = (nums[i] + 1) / 2; // Apply op1
            if (newVal >= k) {
                newVal = newVal - k; // Apply op2
                int applyOp1Op2 = newVal + solve(nums, k, i + 1, op1 - 1, op2 - 1);
                result = Math.min(result, applyOp1Op2);
            }

            if (nums[i] >= k) { // Apply op2 first
                newVal = nums[i] - k;
                newVal = (newVal + 1) / 2; // Apply op1
                int applyOp2Op1 = newVal + solve(nums, k, i + 1, op1 - 1, op2 - 1);
                result = Math.min(result, applyOp2Op1);
            }
        }

        // No operation applied
        result = Math.min(result, nums[i] + solve(nums, k, i + 1, op1, op2));

        return memo[i][op1][op2] = result;
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        n = nums.length;
        memo = new int[n][op1 + 1][op2 + 1];
        for (int[][] mat : memo) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return solve(nums, k, 0, op1, op2);
    }
}
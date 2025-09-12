// Last updated: 13/09/2025, 01:49:42
class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canSplit(int[] nums, int k, int maxSumAllowed) {
        int subarrays = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num > maxSumAllowed) {
                subarrays++;
                currentSum = num;
                if (subarrays > k) return false;
            } else {
                currentSum += num;
            }
        }
        return true;
    }
}

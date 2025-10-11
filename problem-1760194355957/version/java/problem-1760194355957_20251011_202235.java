// Last updated: 11/10/2025, 20:22:35
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;

        int maxlen = 2;
        int currlen = 2;

        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[i - 1] + nums[i - 2]) {
                currlen++;
            } else {
                currlen = 2; // reset count if not Fibonacci-like
            }
            maxlen = Math.max(maxlen, currlen);
        }

        return maxlen;
    }
}
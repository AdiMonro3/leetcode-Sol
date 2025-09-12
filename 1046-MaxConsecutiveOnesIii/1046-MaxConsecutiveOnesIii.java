// Last updated: 13/09/2025, 01:48:12
class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[i] == 0) {
                    k++;
                }
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
}
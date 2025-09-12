// Last updated: 13/09/2025, 01:48:47
class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0; // Count of modifications needed
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                 count++;
                // If more than one modification is required, return false
                if (count > 1) {
                    return false;
                }
                 

                // Adjust the array to maintain non-decreasing order
                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i]; // Modify nums[i-1] if possible
                } else {
                    nums[i] = nums[i - 1]; // Otherwise, modify nums[i]
                }
            }
        }
        return true;
    }
    }

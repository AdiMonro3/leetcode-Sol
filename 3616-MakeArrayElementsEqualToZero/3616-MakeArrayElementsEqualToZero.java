// Last updated: 12/09/2025, 15:03:02
class Solution {
    public int countValidSelections(int[] nums) {
   
        int n = nums.length;
        int validCount = 0;

        // Try every starting position and both directions
        for (int start = 0; start < n; start++) {
            if (nums[start] == 0) {
                // Simulate for both directions
                if (simulate(nums.clone(), start, 1)) validCount++;
                if (simulate(nums.clone(), start, -1)) validCount++;
            }
        }
        return validCount;
    }

    private boolean simulate(int[] nums, int curr, int direction) {
        int n = nums.length;

        while (curr >= 0 && curr < n) {
            if (nums[curr] == 0) {
                curr += direction; // Move in the current direction
            } else if (nums[curr] > 0) {
                nums[curr]--;      // Decrement the current value
                direction = -direction; // Reverse direction
                curr += direction; // Move in the new direction
            }
        }

        // Check if the array is all zeroes
        for (int num : nums) {
            if (num != 0) return false;
        }
        return true;
    }
}
    

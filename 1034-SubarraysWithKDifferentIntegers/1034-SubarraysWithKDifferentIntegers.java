// Last updated: 13/09/2025, 01:48:15
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int left = 0, right = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (right < nums.length) {
            int current = nums[right];
            map.put(current, map.getOrDefault(current, 0) + 1);
            if (map.get(current) == 1) {
                k--; // New unique integer
            }

            while (k < 0) {
                int leftNum = nums[left];
                map.put(leftNum, map.get(leftNum) - 1);
                if (map.get(leftNum) == 0) {
                    k++; // One unique integer removed
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
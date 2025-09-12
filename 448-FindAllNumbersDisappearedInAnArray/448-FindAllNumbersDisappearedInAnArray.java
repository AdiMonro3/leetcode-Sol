// Last updated: 13/09/2025, 01:49:33
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            int index = Math.abs(num) - 1; // since values are from 1 to n
            if (nums[index] > 0) {
                nums[index] = -nums[index]; // mark as seen
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // index + 1 is missing
            }
        }

        return result;
    }
}
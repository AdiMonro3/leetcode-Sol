// Last updated: 13/09/2025, 01:48:55
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];  // add the smaller of each pair
        }

        return sum;
    }
}
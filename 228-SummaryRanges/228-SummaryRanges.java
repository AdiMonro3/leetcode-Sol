// Last updated: 13/09/2025, 01:50:29
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            int start = i;

            // move i forward while the next number is consecutive
            while (i + 1 < nums.length && nums[i + 1] == nums[i] + 1) {
                i++;
            }

            // build the range string
            if (start == i) {
                res.add(String.valueOf(nums[start]));
            } else {
                res.add(nums[start] + "->" + nums[i]);
            }

            i++;
        }

        return res;
    }
}
// Last updated: 19/10/2025, 08:24:36
class Solution {
    public int missingMultiple(int[] nums, int k) {
         Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int i = 1;
        while (true) {
            int multiple = i * k;
            if (!numSet.contains(multiple)) {
                return multiple;
            }
            i++;
        }
    }
}
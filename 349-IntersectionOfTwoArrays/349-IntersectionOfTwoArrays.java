// Last updated: 13/09/2025, 01:49:53
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // Add all elements of nums1 to set1
        for (int num : nums1) {
            set1.add(num);
        }

        // Check if elements in nums2 are present in set1
        for (int num : nums2) {
            if (set1.contains(num)) {
                result.add(num); // Add to result set (automatically unique)
            }
        }

        // Convert the result set to an int[]
        int[] res = new int[result.size()];
        int i = 0;
        for (int num : result) {
            res[i++] = num;
        }

        return res;
    }
}
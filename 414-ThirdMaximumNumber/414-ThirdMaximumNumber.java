// Last updated: 13/09/2025, 01:49:40
class Solution {
    public int thirdMax(int[] nums) {
        
    TreeSet<Integer> top3 = new TreeSet<>();

        for (int num : nums) {
            top3.add(num);
            if (top3.size() > 3) {
                top3.pollFirst(); // Remove the smallest to keep only top 3
            }
        }

        // If we have 3 distinct max numbers
        if (top3.size() == 3) {
            return top3.first(); // Third max
        }

        // Else, return the maximum
        return top3.last();
    }
}
// Last updated: 13/09/2025, 01:47:45
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int res = 0;

        for(int num : nums){
            res += countMap.getOrDefault(num, 0); // add good pairs with previous occurrences
            countMap.put(num, countMap.getOrDefault(num, 0) + 1); // increment frequency
        }

        return res;
    }
}

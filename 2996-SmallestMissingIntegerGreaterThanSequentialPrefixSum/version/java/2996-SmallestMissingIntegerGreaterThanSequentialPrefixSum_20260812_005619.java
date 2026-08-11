// Last updated: 12/08/2026, 00:56:19
1class Solution {
2    public int missingInteger(int[] nums) {
3         int prefixSum = nums[0];
4        for (int i = 1; i < nums.length; i++) {
5            if (nums[i] == nums[i - 1] + 1) {
6                prefixSum += nums[i];
7            } else {
8                break; // Stop immediately when the sequential order breaks
9            }
10        }
11        
12        // Step 2: Add all elements of nums to a HashSet for O(1) lookup
13        Set<Integer> numSet = new HashSet<>();
14        for (int num : nums) {
15            numSet.add(num);
16        }
17        
18        // Step 3: Find the smallest missing integer >= prefixSum
19        while (numSet.contains(prefixSum)) {
20            prefixSum++;
21        }
22        
23        return prefixSum;
24    }
25}
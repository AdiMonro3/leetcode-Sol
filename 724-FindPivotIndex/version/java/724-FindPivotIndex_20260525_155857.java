// Last updated: 25/05/2026, 15:58:57
1class Solution {
2    public int pivotIndex(int[] nums) {
3
4        int totalSum = 0;
5
6        // Calculate total sum
7        for(int num : nums) {
8            totalSum += num;
9        }
10
11        int leftSum = 0;
12
13        // Traverse array
14        for(int i = 0; i < nums.length; i++) {
15
16            int rightSum = totalSum - leftSum - nums[i];
17
18            if(leftSum == rightSum) {
19                return i;
20            }
21
22            leftSum += nums[i];
23        }
24
25        return -1;
26    }
27}
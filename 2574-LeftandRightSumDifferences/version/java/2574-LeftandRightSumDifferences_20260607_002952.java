// Last updated: 07/06/2026, 00:29:52
1class Solution {
2    public int[] leftRightDifference(int[] nums) {
3        int n = nums.length;
4
5        int totalSum = 0;
6        for (int num : nums) {
7            totalSum += num;
8        }
9
10        int[] answer = new int[n];
11        int leftSum = 0;
12
13        for (int i = 0; i < n; i++) {
14            int rightSum = totalSum - leftSum - nums[i];
15
16            answer[i] = Math.abs(leftSum - rightSum);
17
18            leftSum += nums[i];
19        }
20
21        return answer;
22    }
23}
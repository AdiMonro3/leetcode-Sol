// Last updated: 22/04/2026, 19:12:32
1class Solution {
2    public double findMaxAverage(int[] nums, int k) {
3        int n = nums.length;
4
5        // Step 1: initial window sum
6        int sum = 0;
7        for (int i = 0; i < k; i++) {
8            sum += nums[i];
9        }
10
11        int maxSum = sum;
12
13        // Step 2: slide window
14        for (int i = k; i < n; i++) {
15            sum += nums[i];        // add next
16            sum -= nums[i - k];    // remove left
17            
18            maxSum = Math.max(maxSum, sum);
19        }
20
21        return (double) maxSum / k;
22    }
23}
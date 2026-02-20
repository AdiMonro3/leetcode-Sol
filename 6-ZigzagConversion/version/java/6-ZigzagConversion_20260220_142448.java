// Last updated: 20/02/2026, 14:24:48
1class Solution {
2    public int threeSumClosest(int[] nums, int target) {
3         // 🔹 Step 1: Sort the array
4        Arrays.sort(nums);
5
6        int n = nums.length;
7
8        // 🔹 Initialize answer with some valid triplet sum
9        int closestSum = nums[0] + nums[1] + nums[2];
10
11        // 🔹 Step 2: Fix the first element
12        for (int i = 0; i < n - 2; i++) {
13
14            int left = i + 1;
15            int right = n - 1;
16
17            // 🔹 Step 3: Two-pointer search
18            while (left < right) {
19
20                int currentSum = nums[i] + nums[left] + nums[right];
21
22                // 🧠 Update closest if current is better
23                if (Math.abs(target - currentSum) < Math.abs(target - closestSum)) {
24                    closestSum = currentSum;
25                }
26
27                // 🎯 Perfect match — cannot get closer
28                if (currentSum == target) {
29                    return currentSum;
30                }
31                // Need bigger sum → move left forward
32                else if (currentSum < target) {
33                    left++;
34                }
35                // Need smaller sum → move right backward
36                else {
37                    right--;
38                }
39            }
40        }
41
42        return closestSum;
43    }
44}
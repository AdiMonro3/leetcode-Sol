// Last updated: 17/07/2026, 13:10:25
1class Solution {
2    int MOD = 1000000007;
3
4    public int minimumCost(int[] nums, int k) {
5        long cost = 0;
6        long opCount = 0;
7        long resources = k;
8
9        // Process sequentially from left to right as required
10        for (int i = 0; i < nums.length; i++) {
11            if (resources >= nums[i]) {
12                resources -= nums[i];
13            } else {
14                // Calculate the exact amount of resources deficit
15                long needed = nums[i] - resources;
16                
17                // Ceiling division to find operations needed: ceil(needed / k)
18                long opsNeeded = (needed + k - 1) / k; 
19
20                // Determine the starting and ending operation costs
21                long startOp = opCount + 1;
22                long endOp = opCount + opsNeeded;
23                
24                // Sum of an Arithmetic Progression: (start + end) * count / 2
25                // We apply modulo to parts of the product to prevent long overflow
26                long addedCost = 0;
27                if ((startOp + endOp) % 2 == 0) {
28                    addedCost = (((startOp + endOp) / 2) % MOD) * (opsNeeded % MOD);
29                } else {
30                    addedCost = ((startOp + endOp) % MOD) * ((opsNeeded / 2) % MOD);
31                }
32                addedCost %= MOD;
33
34                // Update the total accumulated cost
35                cost = (cost + addedCost) % MOD;
36
37                // Replenish resources and update the global operation count
38                resources += opsNeeded * k;
39                opCount += opsNeeded;
40
41                // Deduct the current element's cost
42                resources -= nums[i];
43            }
44        }
45        return (int) cost;
46    }
47}
48
// Last updated: 15/05/2026, 03:08:19
1
2
3class Solution {
4    public boolean isGood(int[] nums) {
5        int n = 0;
6        
7        // Step 1: Find max element
8        for (int num : nums) {
9            n = Math.max(n, num);
10        }
11        
12        // Step 2: Check length
13        if (nums.length != n + 1) return false;
14        
15        // Step 3: Frequency array
16        int[] freq = new int[n + 1];
17        
18        for (int num : nums) {
19            if (num > n) return false;
20            freq[num]++;
21        }
22        
23        // Step 4: Check conditions
24        if (freq[n] != 2) return false;
25        
26        for (int i = 1; i < n; i++) {
27            if (freq[i] != 1) return false;
28        }
29        
30        return true;
31    }
32}
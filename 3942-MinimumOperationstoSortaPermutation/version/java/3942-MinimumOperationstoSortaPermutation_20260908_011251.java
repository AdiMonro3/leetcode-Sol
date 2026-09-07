// Last updated: 08/09/2026, 01:12:51
1class Solution {
2    public int minOperations(int[] nums) {
3        int n = nums.length;
4        if (n <= 1) return 0;
5        
6        int drops = 0;  // Counts "falling cliffs"
7        int climbs = 0; // Counts "rising cliffs"
8        int p = 0;      // Will store the index of the element '0'
9        
10        // Single pass to analyze the shape and find the target element
11        for (int i = 0; i < n; i++) {
12            if (nums[i] == 0) {
13                p = i;
14            }
15            
16            // Compare current element with the next (wrapping around to the start)
17            if (nums[i] > nums[(i + 1) % n]) {
18                drops++;
19            } else if (nums[i] < nums[(i + 1) % n]) {
20                climbs++;
21            }
22        }
23        
24        // Scenario 1: Shifted Ascending
25        if (drops <= 1) {
26            // Path 1: Rotate Left 'p' times.
27            // Path 2: Reverse, Rotate Left 'n-p' times, Reverse back (+2 operations).
28            return Math.min(p, n - p + 2);
29        } 
30        // Scenario 2: Shifted Descending
31        else if (climbs <= 1) {
32            // Path 1: Rotate Left 'p+1' times to push 0 to the back, then Reverse (+1 operation).
33            // Path 2: Reverse immediately (+1), then Rotate Left 'n-1-p' times.
34            return Math.min(p + 2, n - p);
35        }
36        
37        // Scenario 3: The array is scrambled and cannot be fixed
38        return -1;
39    }
40}
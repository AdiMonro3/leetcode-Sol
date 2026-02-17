// Last updated: 18/02/2026, 03:55:49
1class Solution {
2    private boolean isPossible(int[] nums, int mid, int k) {
3        int house = 0;
4        for (int i = 0; i < nums.length; i++) {
5            if (nums[i] <= mid) {
6                house++;
7                i++; // skipping adjacent house
8            }
9        }
10        
11        return house >= k; // we managed to rob at least k houses
12    }
13    
14    public int minCapability(int[] nums, int k) {
15        int n = nums.length;
16        
17        int l = Arrays.stream(nums).min().getAsInt();
18        int r = Arrays.stream(nums).max().getAsInt();
19        
20        int result = r;
21        
22        while (l <= r) { // O(log(maxC) * n )
23            int mid = l + (r - l) / 2; // capability
24            
25            if (isPossible(nums, mid, k)) {
26                result = mid;
27                r = mid - 1;
28            } else {
29                l = mid + 1;
30            }
31        }
32        
33        return result;
34    }
35}
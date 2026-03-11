// Last updated: 11/03/2026, 13:30:26
1class Solution {
2    public int maxProduct(int[] nums) {
3        int prod = 1;
4        int result = Integer.MIN_VALUE;
5        
6        for (int i = 0; i < nums.length; i++) {
7            prod = prod * nums[i];
8            result = Math.max(prod, result);
9            if(prod == 0) {
10                prod = 1;
11            }
12        }
13        prod = 1;
14        
15        for (int i = nums.length - 1; i >= 0; i--) {
16            prod = prod * nums[i];
17            result = Math.max(prod, result);
18            if(prod == 0) {
19                prod = 1;
20            }      
21        }
22        return result;
23
24    }
25}
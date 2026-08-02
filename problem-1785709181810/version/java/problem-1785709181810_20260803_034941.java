// Last updated: 03/08/2026, 03:49:41
1class Solution {
2    public long maxPairStrength(int[] nums) {
3        long maxStrength = 0;
4        int n = nums.length;
5        
6        for (int i = 0; i < n; i++) {
7            for (int j = i + 1; j < n; j++) {
8                long g = gcd(nums[i], nums[j]);
9                long strength = ((long) nums[i] * nums[j]) / (g * g);
10                if (strength > maxStrength) {
11                    maxStrength = strength;
12                }
13            }
14        }
15        return maxStrength;
16    }
17    
18    private long gcd(long a, long b) {
19        while (b != 0) {
20            long temp = b;
21            b = a % b;
22            a = temp;
23        }
24        return a;
25    }
26}
27
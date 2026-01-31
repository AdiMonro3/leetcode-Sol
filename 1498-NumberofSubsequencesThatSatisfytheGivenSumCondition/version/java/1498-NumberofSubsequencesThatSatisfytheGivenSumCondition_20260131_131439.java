// Last updated: 31/01/2026, 13:14:39
1class Solution {
2   int MOD = 1_000_000_007;
3
4    public int numSubseq(int[] nums, int target) {
5        int n=nums.length;
6        Arrays.sort(nums);
7        long[] pow = new long[n];
8        pow[0] = 1;
9        for (int i = 1; i < n; i++) {
10            pow[i] = (pow[i - 1] * 2) % MOD;
11        }
12        int l=0;
13        int r=n-1;
14        long result=0;
15        while(l<=r){
16            if(nums[l]+nums[r]<=target){
17                result=(result + pow[r - l])%MOD;
18                l++;
19            }else{
20                r--;
21            }
22        }
23        return (int)result;
24
25    }
26}
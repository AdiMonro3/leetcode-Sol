// Last updated: 27/07/2026, 17:35:17
1class Solution {
2    public int maxProduct(int[] nums) {
3        int n=nums.length;
4        Arrays.sort(nums);
5        int a=nums[n-1]-1;
6        int b=nums[n-1]-1;
7        System.out.println(a+" "+b);
8        return ((nums[n-1]-1)*(nums[n-2]-1));
9    }
10}
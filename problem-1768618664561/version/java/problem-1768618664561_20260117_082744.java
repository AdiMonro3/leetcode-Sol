// Last updated: 17/01/2026, 08:27:44
1class Solution {
2    public int centeredSubarrays(int[] nums) {
3        int count=0;
4        for(int i=0;i<nums.length;i++){
5            int sum=0;
6            HashSet<Integer> set=new HashSet<>();
7            for(int j=i;j<nums.length;j++){
8                sum+=nums[j];
9                set.add(nums[j]);
10                if(set.contains(sum)) count++;
11            }
12        }
13        return count;
14    }
15}
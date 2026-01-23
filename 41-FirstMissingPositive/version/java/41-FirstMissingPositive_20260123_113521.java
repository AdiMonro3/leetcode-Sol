// Last updated: 23/01/2026, 11:35:21
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n=nums.length;
4        for(int i=0;i<nums.length;i++){
5             while (
6                nums[i] >= 1 &&
7                nums[i] <= n &&
8                nums[nums[i] - 1] != nums[i]
9            ) {
10                int correctIndex = nums[i] - 1;
11                // Swap nums[i] with nums[correctIndex]
12                int temp = nums[i];
13                nums[i] = nums[correctIndex];
14                nums[correctIndex] = temp;
15            }
16        }
17        for(int i=0;i<nums.length;i++){
18            if(nums[i]!=i+1){
19                return i+1;
20                
21            }
22        }
23        return nums.length+1;
24    }
25}
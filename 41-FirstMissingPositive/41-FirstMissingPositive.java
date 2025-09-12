// Last updated: 13/09/2025, 01:52:10
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
             while (
                nums[i] >= 1 &&
                nums[i] <= n &&
                nums[nums[i] - 1] != nums[i]
            ) {
                int correctIndex = nums[i] - 1;
                // Swap nums[i] with nums[correctIndex]
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
                
            }
        }
        return nums.length+1;
    }
}
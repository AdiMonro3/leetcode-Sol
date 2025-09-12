// Last updated: 13/09/2025, 01:47:58
class Solution {
    public static int helper(int nums[],int k){
        int i=0;
        int count=0;
        int odd=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2!=0){
                odd++;
            }
            while(odd>k){
                if(nums[i]%2!=0){
                    odd--;
                }
                i++;
            }
            
            count+=j-i+1;
           
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
}
// Last updated: 13/09/2025, 01:48:22
class Solution {
    public static int helper(int nums[],int goal){
         if(goal<0) return 0;
        int count=0;
        int i=0,j=0;
        int sum=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>goal){
                sum-=nums[i];
                i++;
            }
            if(sum<=goal){
                count+=j-i+1;
            }
            j++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
           int ans=helper(nums,goal)-helper(nums,goal-1);
           return ans;
         
    }
}
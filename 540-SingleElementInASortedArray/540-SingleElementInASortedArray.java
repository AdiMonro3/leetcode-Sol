// Last updated: 13/09/2025, 01:49:06
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lb=1;
        int ub=nums.length-2;
        if(nums.length==1) return nums[0];
        if(nums[0]!=nums[1]) return nums[0];
        if(nums[nums.length-1]!=nums[nums.length-2]) return nums[nums.length-1];
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            if(mid%2==1 && nums[mid]==nums[mid-1] || mid%2==0 && nums[mid]==nums[mid+1]){
                lb=mid+1;
            }
            else{
                ub=mid-1;
            }
            
        }
        return -1;
    }
}
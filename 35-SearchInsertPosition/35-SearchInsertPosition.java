// Last updated: 13/09/2025, 01:52:14
class Solution {
    public int searchInsert(int[] nums, int target) {
        int lb=0;
        int ub=nums.length-1;
        int Insert_idx=Integer.MAX_VALUE;
        if(nums[ub]<target) return nums.length;
        if(nums[lb]>target) return lb;
        while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(nums[mid]>target){
                Insert_idx=Math.min(Insert_idx,mid);
                ub=mid-1;
            }
            else if(nums[mid]<target){
                lb=mid+1;
            }
            else return mid;
        }
        return Insert_idx;
    }
}
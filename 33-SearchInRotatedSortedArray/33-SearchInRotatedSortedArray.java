// Last updated: 13/09/2025, 01:52:17
class Solution {
    public int search(int[] nums, int target) {
        int lb=0;
        int ub=nums.length-1;
        while(lb<=ub){
            boolean sorted=false;
            int mid=lb+(ub-lb)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[lb]<=nums[mid]){
                sorted=true;
            }
            if(sorted){
                if(nums[lb]<=target && target<=nums[mid]){
                    ub=mid-1;
                }
                else{
                    lb=mid+1;
                }

            }
            else{
                if(nums[mid]<=target && target<=nums[ub]){
                        lb=mid+1;
                    }
                    else{
                        ub=mid-1;
                    }
            }
        }
        return -1;
    }
}
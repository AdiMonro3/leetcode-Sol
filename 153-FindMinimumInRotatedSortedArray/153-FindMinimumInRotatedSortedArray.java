// Last updated: 13/09/2025, 01:51:03
class Solution {
    public int findMin(int[] nums) {
       int lb=0;
       int ub=nums.length-1;
       int min=Integer.MAX_VALUE;
       while(lb<=ub){
        int mid=lb+(ub-lb)/2;
        if(nums[lb]<=nums[mid]){
            min=Math.min(min,nums[lb]);
            lb=mid+1;
        }
        else{
            min=Math.min(min,nums[mid]);
            ub=mid-1;
        }
       }
       return min;
    }
}
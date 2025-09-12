// Last updated: 13/09/2025, 01:47:56
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
        }
        int low=1;
        int high=max;
        while(low<=high){
            int mid=(high+low)/2;
            int sum=0;
            for(int i=0;i<nums.length;i++){
                int x= (nums[i] + mid - 1) / mid;
                sum+=x;
            }
            if(sum<=threshold){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}
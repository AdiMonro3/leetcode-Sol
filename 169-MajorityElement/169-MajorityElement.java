// Last updated: 13/09/2025, 01:50:57
class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1) return nums[0];
        int count=1;
        int candidate=nums[0];
       for(int i=1;i<nums.length;i++){
        if(candidate==nums[i]){
            count++;
        }
        else{
            count--;
        }
        if(count<=0){
            candidate=nums[i+1];
        }
       }
       return candidate;
    }
}
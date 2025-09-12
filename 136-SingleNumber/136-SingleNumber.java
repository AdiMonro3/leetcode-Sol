// Last updated: 13/09/2025, 01:51:13
class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor=xor^nums[i];
        }
        return xor;
    }
}
// Last updated: 13/09/2025, 01:52:23
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 1;
        }
        int i=0;
        int j=1;
        while(j<=n-1){
            if(nums[i]!=nums[j]){
                 i++;
                // int temp=nums[i];
                nums[i]=nums[j];
                // nums[j]=temp;
                j++;
              }
            else j++;
              
        }
        
        return i-0+1;

    }
}
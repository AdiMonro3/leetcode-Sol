// Last updated: 13/09/2025, 01:50:54
class Solution {
    void Reverse(int []nums,int i,int j){
        if(nums.length<=1){
            return;
        }
       
         while(i<=j){
          int  temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
            }
    }
    public void rotate(int[] nums, int k) {
         // Reverse first n-k elements
         int n=nums.length;
          k=k%n;
    Reverse(nums, 0, n - k - 1);
    // Reverse last k elements
    Reverse(nums, n - k, n - 1);
    // Reverse whole array
    Reverse(nums, 0, n - 1);
       
        
    }
}
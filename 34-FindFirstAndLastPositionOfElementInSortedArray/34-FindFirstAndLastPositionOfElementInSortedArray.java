// Last updated: 13/09/2025, 01:52:16
class Solution {
    public static int Occurance(int []nums,int target,boolean Return_last){
        int lb=0;
        int ub=nums.length-1;
        int last=Integer.MIN_VALUE;
        int first=Integer.MAX_VALUE;
         while(lb<=ub){
            int mid=lb+(ub-lb)/2;
            if(nums[mid]>target){
                ub=mid-1;
            }
            else if(nums[mid]<target){
                lb=mid+1;
            }
            else{
                if(Return_last){
                    last=Math.max(last,mid);
                    lb=mid+1;}
                else{
                    first=Math.min(first,mid);
                    ub=mid-1;
                }
            }
        }
        if(Return_last){
        return last;
        }
        return first;
    }
    public int[] searchRange(int[] nums, int target) {
        int [] ans={-1,-1};
        int last=Occurance(nums,target,true);
        int first=Occurance(nums,target,false);

        if(last==Integer.MIN_VALUE && first==Integer.MAX_VALUE){
            return ans;
        }
            ans[0]=first;
            ans[1]=last;
            return ans;
        
    }
}
// Last updated: 13/09/2025, 01:49:21
class Solution {
    public static int merge(int[]nums,int low,int mid,int high){
        int count=0;
        int left=low;
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)nums[i]>2*(long)nums[right]) {
                right++;
            }
            count+=right-(mid+1);
        }
         right=mid+1;
        ArrayList<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }else{
                temp.add(nums[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        return count;
    }
    public static int mergesort(int []nums,int low,int high){
        int count=0;
        if(low==high) return count;
        int mid=(low+high)/2;
        count+=mergesort(nums,low,mid);
        count+=mergesort(nums,mid+1,high);
        count+=merge(nums,low,mid,high);
        return count;

    }
    public int reversePairs(int[] nums) {
        int low=0;
        int high=nums.length-1;
        return mergesort(nums,low,high);
    }
}
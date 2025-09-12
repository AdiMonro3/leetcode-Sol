// Last updated: 13/09/2025, 01:50:04
class Solution {
    public void merge(int [] nums,int []idx,int left,int mid,int right,int []count){
        int[] temp = new int[right - left + 1];
        int i=left;
        int j=mid+1;
        int k=0;
        int counter=0;
        while(i<=mid && j<=right){
            if(nums[idx[j]]<nums[idx[i]]){
                temp[k]=idx[j];
                counter++;
                k++;
                j++;
            }else{
                count[idx[i]]+=counter;
                temp[k]=idx[i];
                i++;
                k++;
            }
        }
        while (i <= mid) {
            count[idx[i]] += counter;
            temp[k++] = idx[i++];
        }

        while (j <= right) {
            temp[k++] = idx[j++];
        }
        for (int l = 0; l < temp.length; l++) {
            idx[left + l] = temp[l];
        }
    }
    public void mergesort(int [] arr,int []idx,int left,int right,int []count){
        if(left==right) return;
        int mid=(right+left)/2;
        mergesort(arr,idx,left,mid,count);
        mergesort(arr,idx,mid+1,right,count);
        merge(arr,idx,left,mid,right,count);
    }
    public List<Integer> countSmaller(int[] nums) {
        int numidx[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            numidx[i]=i;
        }
        int count[]=new int[nums.length];
        mergesort(nums,numidx,0,nums.length-1,count);

        List<Integer> resList = new ArrayList<>();
        for (int c : count) {
            resList.add(c);
        }
        return resList;

    }
}
// Last updated: 13/09/2025, 01:47:44
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(high+low)/2;
            int missing=arr[mid]-1-mid;
            if(missing<k){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        
        return k+high+1;
    }
}
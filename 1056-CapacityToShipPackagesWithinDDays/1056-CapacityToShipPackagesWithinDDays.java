// Last updated: 13/09/2025, 01:48:10
class Solution {
    public static int req_days(int[] weights,int mid){
        int days=0;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]<=mid){
                load+=weights[i];
            }
            else{
                days++;
                load=weights[i];
            }
        }
        return days;

    }
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<weights.length;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        while(low<=high){
            int mid=(high+low)/2;
            int no_days=req_days(weights,mid);
            if(no_days<days){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
        
    }
}
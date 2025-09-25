// Last updated: 25/09/2025, 20:16:04
class Solution {
    public int maxProfit(int[] arr) {
        int minptr=0;
        int min=0;
        int profit=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[minptr]){
                minptr=i;
            }
            else{
                int prof=arr[i]-arr[minptr];
                if(prof>profit){
                    profit=prof;
                }
            }
        }
        return profit;
    }
}
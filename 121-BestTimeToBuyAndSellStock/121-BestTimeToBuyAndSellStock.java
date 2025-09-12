// Last updated: 13/09/2025, 01:51:21
class Solution {
    public int maxProfit(int[] prices) {
        int sell=1;
        int buy=0;
        int profit =0;
        int fprofit=0;
        while(sell<prices.length){
            if(prices[sell]-prices[buy]<=0){
               // sell++;
                buy=sell;
                profit=0;
            }
                profit=prices[sell]-prices[buy];
            if(profit>fprofit){
                fprofit=profit;
            }
                sell++;

            
        }
        return fprofit;
    }
}
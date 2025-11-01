// Last updated: 01/11/2025, 20:36:00
class Solution {
    int dp[];
    public int helper(int[] days,int[] costs,int idx){
        if(idx>=days.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int a=costs[0]+helper(days,costs,idx+1);

        int i=idx;
        while(i<days.length && days[i]<days[idx]+7){
            i++;
        }
        int b=costs[1]+helper(days,costs,i);

        int j=idx;
        while(j<days.length && days[j]<days[idx]+30){
            j++;
        }
        int c=costs[2]+helper(days,costs,j);

        return dp[idx]=Math.min(a,Math.min(b,c));
    }
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return helper(days,costs,0);
    }
}
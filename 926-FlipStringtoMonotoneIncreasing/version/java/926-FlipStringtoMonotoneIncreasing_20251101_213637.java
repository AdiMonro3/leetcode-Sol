// Last updated: 01/11/2025, 21:36:37
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(days[i]);
        }

        int dp[]=new int[days[n-1]+1];
        int m=dp.length;

        for(int i=1;i<m;i++){
            if(!set.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }

            int d1=costs[0]+dp[i-1];
            int d7=costs[1]+dp[Math.max(i-7,0)];
            int d30=costs[2]+dp[Math.max(i-30,0)];

            dp[i]=Math.min(d1,Math.min(d7,d30));
        }
        return dp[m-1];
    }
}
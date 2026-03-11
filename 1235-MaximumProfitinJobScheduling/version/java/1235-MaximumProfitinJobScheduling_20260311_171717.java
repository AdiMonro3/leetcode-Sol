// Last updated: 11/03/2026, 17:17:17
1class Solution {
2    class Pair{
3        int start;
4        int end;
5        int cost;
6        Pair(int start,int end,int cost){
7            this.start=start;
8            this.end=end;
9            this.cost=cost;
10        }
11    }
12    int dp[];
13    public int nextJob(int[] start,int end){
14
15        int l=0, r=start.length;
16
17        while(l<r){
18            int mid = (l+r)/2;
19
20            if(start[mid] < end)
21                l = mid+1;
22            else
23                r = mid;
24        }
25
26        return l;
27    }
28    public int helper(int[] start,int[] end,int[] cost,int i){
29        if(i>=start.length) return 0;
30        if(dp[i] != -1) return dp[i];
31
32        int next = nextJob(start,end[i]);
33
34        int pick=cost[i]+helper(start,end,cost,next);
35        int notpick=helper(start,end,cost,i+1);
36
37        return   dp[i] = Math.max(pick,notpick);
38    }
39    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
40        int n=startTime.length;
41        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.start-b.start);
42        for(int i=0;i<n;i++){
43            int s=startTime[i];
44            int e=endTime[i];
45            int c=profit[i];
46
47            pq.offer(new Pair(s,e,c));
48        }
49        for(int i=0;i<n;i++){
50            Pair p=pq.poll();
51            int start=p.start;
52            int end=p.end;
53            int cost=p.cost;
54
55            startTime[i]=start;
56            endTime[i]=end;
57            profit[i]=cost;
58        }
59        dp=new int[n];
60        Arrays.fill(dp,-1);
61        return helper(startTime,endTime,profit,0);
62    }
63}
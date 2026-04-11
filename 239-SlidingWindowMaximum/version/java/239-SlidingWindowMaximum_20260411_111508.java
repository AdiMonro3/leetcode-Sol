// Last updated: 11/04/2026, 11:15:08
1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int n=nums.length;
4
5        Queue<int[]> pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
6
7        int i=0;
8        int j=0;
9
10        int[] ans=new int[n-k+1];
11        int idx=0;
12
13        while(j<n){
14            pq.add(new int[]{nums[j],j});
15            if((j-i+1)==k){
16                while(!pq.isEmpty() && pq.peek()[1]>j || pq.peek()[1]<i){
17                    pq.poll();
18                }
19                ans[idx]=pq.peek()[0];
20                idx++;
21                i++;
22            }
23            j++;
24        }
25        return ans;
26    }
27}
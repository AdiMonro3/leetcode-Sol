// Last updated: 07/02/2026, 22:44:04
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] t:times){
            int u=t[0]-1;
            int v=t[1]-1;
            int time=t[2];
            adj.get(u).add(new int[]{v,time});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.add(new int[]{0,k-1});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int time=curr[0];
            int nd=curr[1];
            if (time>dist[nd])
                continue;
            for(int[] nei:adj.get(nd)){
                int nei_node=nei[0];
                int nei_time=nei[1];
                if(time+nei_time<dist[nei_node]){
                    dist[nei_node]=time+nei_time;
                    pq.add(new int[]{time+nei_time,nei_node});
                }
            }
        }
        int mx=dist[0];
        for(int i=0;i<n;i++){
            if (mx<dist[i])
                mx=dist[i];
        }
        if(mx==Integer.MAX_VALUE)
            return -1;
        return mx;


    }
}
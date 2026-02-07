// Last updated: 07/02/2026, 22:39:16
1class Solution {
2    class Pair{
3        int val;
4        int wt;
5        public Pair(int val,int wt){
6            this.val=val;
7            this.wt=wt;
8        }
9    }
10    public void djkistra( List<List<Pair>> adj,int []dist,int k){
11        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.wt-b.wt);
12        q.offer(new Pair(k,0));
13        while(!q.isEmpty()){
14            Pair t=q.poll();
15            int node=t.val;
16            int d=t.wt;
17
18            for(Pair p:adj.get(node)){
19                int v=p.val;
20                int w=p.wt;
21
22                if(w+d<dist[v]){
23                    dist[v]=w+d;
24                    q.offer(new Pair(v,dist[v]));
25
26                }
27            }
28        }
29    }
30    public int networkDelayTime(int[][] times, int n, int k) {
31
32        List<List<Pair>> adj=new ArrayList<>();
33
34        for(int i=0;i<n+1;i++){
35            adj.add(new ArrayList<>());
36        }
37        for(int i=0;i<times.length;i++){
38            int u=times[i][0];
39            int v=times[i][1];
40            int w=times[i][2];
41
42            adj.get(u).add(new Pair(v,w));
43        }
44
45        int dist[]=new int[n+1];
46        for(int i=0;i<n+1;i++){
47            dist[i]=Integer.MAX_VALUE;
48        }
49        dist[k]=0;
50
51        djkistra(adj,dist,k);
52        int ans=-1;
53        for(int i=1;i<n+1;i++){
54            ans=Math.max(ans,dist[i]);
55        }
56        if(ans==Integer.MAX_VALUE) return -1;
57        return ans;
58
59    }
60}
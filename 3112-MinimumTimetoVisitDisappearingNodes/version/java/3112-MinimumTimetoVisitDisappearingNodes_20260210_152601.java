// Last updated: 10/02/2026, 15:26:01
1class Solution {
2    class Pair{
3        int val;
4        int wt;
5
6        public Pair(int val,int wt){
7            this.val=val;
8            this.wt=wt;
9        }
10    }
11    public void djkistra(List<List<Pair>> adj,int src,int[]dist,int []disp){
12
13        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> a.wt-b.wt);
14
15        pq.add(new Pair(src,0));
16
17        while(!pq.isEmpty()){
18            Pair p=pq.poll();
19
20            int u=p.val;
21            int wt=p.wt;
22
23            if(disp[u]<wt) continue;
24            if(wt>dist[u]) continue;
25            for(Pair t:adj.get(u)){
26                int v=t.val;
27                int w=t.wt;
28                if(dist[u]+w < disp[v] && dist[v]>dist[u]+w){
29                    dist[v]=dist[u]+w;
30
31                    pq.offer(new Pair(v,dist[v]));
32
33                }
34            }
35        }
36
37    }
38    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
39        int [] ans=new int[n];
40
41        List<List<Pair>> adj=new ArrayList<>();
42
43        for(int i=0;i<n;i++){
44            adj.add(new ArrayList<>());
45        }
46        for(int i=0;i<edges.length;i++){
47            int u=edges[i][0];
48            int v=edges[i][1];
49            int w=edges[i][2];
50
51            adj.get(u).add(new Pair(v,w));
52            adj.get(v).add(new Pair(u,w));
53        }
54        int [] dist=new int[n];
55        Arrays.fill(dist,Integer.MAX_VALUE);
56        dist[0]=0;
57        djkistra(adj,0,dist,disappear);
58        for(int i=0;i<n;i++){
59            if(dist[i]<disappear[i]){
60                ans[i]=dist[i];
61            }else{
62                ans[i]=-1;
63            }
64        }
65        return ans;
66    }
67}
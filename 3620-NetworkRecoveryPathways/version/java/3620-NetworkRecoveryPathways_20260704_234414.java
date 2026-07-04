// Last updated: 04/07/2026, 23:44:14
1class Solution {
2    class Pair{
3        int node;
4        long cost;
5
6        Pair(int node,long cost){
7            this.node=node;
8            this.cost=cost;
9        }
10    }
11    int maxEdgeCost=1000000000+1;
12    public boolean djkistra(List<List<Pair>> adj,boolean[] online,long k,int mid){   
13        int n=online.length;
14        long[] dist=new long[n];
15        Arrays.fill(dist,Long.MAX_VALUE);
16        dist[0]=0;
17        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Long.compare(a.cost, b.cost));
18        pq.offer(new Pair(0,0));
19
20        while(!pq.isEmpty()){
21            Pair p=pq.poll();
22            int node=p.node;
23            long cost=p.cost;
24
25            if(dist[node]<cost) continue;
26            for(Pair temp:adj.get(node)){
27                int v=temp.node;
28                long wt=temp.cost;
29
30                if(wt < mid || wt + cost > k || !online[v]) continue;
31                if(wt+cost<dist[v]){
32                    dist[v]=wt+cost;
33                    pq.add(new Pair(v,wt+cost));
34                }
35            }
36        }
37        if(dist[n-1]!=Long.MAX_VALUE) return true;
38
39        return false;
40    }
41    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
42        int n=online.length;
43        List<List<Pair>> adj=new ArrayList<>();
44        for(int i=0;i<n;i++){
45            adj.add(new ArrayList<>());
46        }
47        for(int[] temp:edges){
48            int u=temp[0];
49            int v=temp[1];
50            int cost=temp[2];
51            adj.get(u).add(new Pair(v,cost));
52        }
53
54        int low=0;
55        int high=maxEdgeCost;
56
57        int result=-1;
58        while(low<high){
59            int mid=low+(high-low)/2;
60
61            if(djkistra(adj,online,k,mid)){
62                low=mid+1;
63                result=Math.max(result,mid);
64            }else{
65                high=mid;
66            }
67
68        }
69        return result;
70
71    }
72}
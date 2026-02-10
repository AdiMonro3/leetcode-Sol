// Last updated: 10/02/2026, 13:54:58
1class Solution {
2    int INF=Integer.MAX_VALUE;
3    class Dsu{
4        int parent[];
5        int cost[];
6
7        public Dsu(int n){
8            parent=new int[n];
9            cost=new int[n];
10            for(int i=0;i<n;i++){
11                parent[i]=i;
12                cost[i]=~0;
13            }
14        }
15
16        int find(int u){
17            if(u==parent[u]) return u;
18
19            return parent[u]=find(parent[u]);
20        }
21
22        boolean union(int u,int v,int wt){
23            int up=find(u);
24            int vp=find(v);
25        
26            if(up==vp){
27                cost[up]&=wt;
28                return false;
29            } 
30
31            parent[vp]=up;
32            cost[up]=cost[up]&cost[vp]&wt;
33
34
35            return true;
36        }
37    }
38    public int[] minimumCost(int n, int[][] edges, int[][] query) {
39        Dsu dsu=new Dsu(n);
40
41        for(int i=0;i<edges.length;i++){
42            int u=edges[i][0];
43            int v=edges[i][1];
44            int wt=edges[i][2];
45
46            dsu.union(u,v,wt);
47        }
48        int ans[]=new int[query.length];
49        for(int i=0;i<query.length;i++){
50            int u=query[i][0];
51            int v=query[i][1];
52
53            int up=dsu.find(u);
54            int vp=dsu.find(v);
55
56            if(up==vp) ans[i]=dsu.cost[up];
57            else ans[i]=-1;
58        }
59        return ans;
60    }
61}
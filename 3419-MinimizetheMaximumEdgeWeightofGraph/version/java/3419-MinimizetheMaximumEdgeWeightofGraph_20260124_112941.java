// Last updated: 24/01/2026, 11:29:41
1class Solution {
2    class Pair{
3        int v;
4        int wt;
5        public Pair(int v,int wt){
6            this.v=v;
7            this.wt=wt;
8        }
9    }
10    public void dfs(List<List<Pair>> adj,int node,int mid,boolean []visited){
11        visited[node]=true;
12        for(Pair neigh:adj.get(node)){
13            int v=neigh.v;
14            int wt=neigh.wt;
15            if(!visited[v] && wt<=mid){
16                
17                dfs(adj,v,mid,visited);
18            }
19        }
20    }
21    public boolean canReach(List<List<Pair>> adj,int n,int mid){
22        boolean[] visited=new boolean[n];
23        dfs(adj,0,mid,visited);
24        for(boolean v:visited){
25            if(!v) return false;
26        }
27        return true;
28    }
29    public int minTheMax(List<List<Pair>> adj,int n,int l,int r){
30        int result=Integer.MAX_VALUE;
31        while(l<=r){
32            int mid = (l+r) / 2;
33            if(canReach(adj,n,mid)){
34                result =mid;
35                r=mid-1;
36            }
37            else{
38                l=mid+1;
39            }
40        }
41        return result;
42    }
43    public int minMaxWeight(int n, int[][] edges, int threshold) {
44        int maxwt=Integer.MIN_VALUE;
45        List<List<Pair>> adj=new ArrayList<>();
46        for(int i=0;i<n;i++){
47            adj.add(new ArrayList<>());
48        }
49        for(int [] e:edges){
50            int u=e[0];
51            int v=e[1];
52            int wt=e[2];
53            adj.get(v).add(new Pair(u,wt));//reverse edge 
54            maxwt=Math.max(maxwt,wt);
55        }
56
57        int result=minTheMax(adj,n,0,maxwt);
58
59        if(result==Integer.MAX_VALUE)  return -1;
60
61        return result;
62    }
63}
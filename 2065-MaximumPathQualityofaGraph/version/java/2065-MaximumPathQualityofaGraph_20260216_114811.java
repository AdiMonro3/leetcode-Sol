// Last updated: 16/02/2026, 11:48:11
1class Solution {
2    class Pair{
3        int val;
4        int wt;
5        Pair (int val,int wt){
6            this.val=val;
7            this.wt=wt;
8        }
9    }
10    int res=0;
11    public void helper(List<List<Pair>> adj,int[] values,int node ,int visited[],int points, int maxTime){
12        if(0==node){
13            res=Math.max(res,points);
14        }
15        if(0>maxTime) return;
16        for(Pair t:adj.get(node)){
17            int v=t.val;
18            int w=t.wt;
19            if(maxTime-w<0) continue;
20                visited[v]++;
21                int gain=0;
22                if(visited[v]==1) gain=values[v];
23                helper(adj,values,v,visited,points+gain,maxTime-w);
24                visited[v]--;
25            
26        }
27    }
28    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
29        List<List<Pair>> adj=new ArrayList<>();
30        int n=values.length;
31        for(int i=0;i<n;i++){
32            adj.add(new ArrayList<>());
33        }
34
35        for(int i=0;i<edges.length;i++){
36            int u=edges[i][0];
37            int v=edges[i][1];
38            int w=edges[i][2];
39
40            adj.get(u).add(new Pair(v,w));
41            adj.get(v).add(new Pair(u,w));
42
43        }
44        int[] visited=new int[n];
45        visited[0]++;
46        helper(adj,values,0,visited,values[0],maxTime);
47
48        return res;
49    }
50}
// Last updated: 05/02/2026, 19:28:59
1class Solution {
2    int n;
3    List<Integer> rank=new ArrayList<>();
4    List<Integer> parent=new ArrayList<>();
5    public int find(int u){
6        if(u==parent.get(u)) return u;
7
8        int ulp=find(parent.get(u));
9        parent.set(u,ulp);
10
11        return parent.get(u);
12    }
13    public boolean union(int u,int v){
14        int ulp_u=find(u);
15        int ulp_v=find(v);
16
17        if(ulp_u==ulp_v) return false;
18
19        if(rank.get(ulp_u)>rank.get(ulp_v)){
20            parent.set(ulp_v,ulp_u);
21        }
22        else if(rank.get(ulp_u)<rank.get(ulp_v)){
23            parent.set(ulp_u,ulp_v);
24        }
25        else{
26            parent.set(ulp_v,ulp_u);
27            int r=rank.get(ulp_u);
28            rank.set(ulp_u,r+1);
29        }
30        return true;
31    }
32    public int[] findRedundantConnection(int[][] edges) {
33        n=edges.length;
34        for (int i = 0; i <= n; i++) {
35            rank.add(0);
36            parent.add(i);
37        }
38        int result=-1;
39        for(int i=0;i<n;i++){
40            int u=edges[i][0];
41            int v=edges[i][1];
42            if(union(u,v)==false){
43                result=Math.max(result,i);
44            }
45        }
46        return edges[result];
47    }
48}
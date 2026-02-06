// Last updated: 06/02/2026, 14:01:09
1class Solution {
2    int bl1=-1;
3    int bl2=-1;
4    int[]parent;
5    public int find(int u){
6        if(u==parent[u]) return u;
7
8        return parent[u]=find(parent[u]);
9    }
10    public boolean union(int u,int v){
11        int ulp=find(u);
12        int vlp=find(v);
13
14        if(ulp==vlp) return true; // cycle present
15
16        parent[vlp]=ulp;
17
18        return false;// cycle not present
19    }
20    public int[] findRedundantDirectedConnection(int[][] edges) {
21        int n=edges.length;
22        parent=new int[n+1];
23        Arrays.fill(parent,-1);
24        for(int i=0;i<n;i++){
25
26            int u=edges[i][0];
27            int v=edges[i][1];
28
29            if(parent[v]==-1){
30                parent[v]=i;
31            }else{
32                bl1=parent[v];
33                bl2=i;
34                break;
35            }
36        }
37        for(int i=0;i<=n;i++){
38            parent[i]=i;
39        }
40        for(int i=0;i<n;i++){
41            if(i==bl2) continue;
42            int u=edges[i][0];
43            int v=edges[i][1];
44
45            if(union(u,v)){
46                if(bl1==-1){
47                    return edges[i]; // case 2 only cycle no double parent
48                }else{
49                    return edges[bl1]; // case 3 if cycle and double parent both 
50                }
51            }
52        }
53        return edges[bl2];
54    }
55}
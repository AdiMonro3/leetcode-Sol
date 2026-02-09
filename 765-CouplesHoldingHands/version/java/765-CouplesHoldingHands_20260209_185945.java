// Last updated: 09/02/2026, 18:59:45
1class Solution {
2    class DSU{
3        int []parent;
4        int []size;
5
6        public DSU(int n){
7            parent=new int[n];
8            size=new int[n];
9
10            for(int i=0;i<n;i++){
11                parent[i]=i;
12                size[i]=1;
13            }
14        }
15
16        int find(int u){
17            if(u==parent[u]) return u;
18
19            return parent[u]=find(parent[u]);
20        }
21
22        boolean Union(int u,int v){
23            int pu=find(u);
24            int pv=find(v);
25
26            if(pu==pv) return false;
27            
28            if(size[pu]<size[pv]){
29                parent[pu]=pv;
30                size[pv]+=size[pu];
31            }else{
32                parent[pv]=pu;
33                size[pu]+=size[pv];
34            }
35
36            return true;
37
38        }
39    }
40    public int minSwapsCouples(int[] row) {
41       int n=row.length/2;
42
43       DSU dsu=new DSU(n);
44
45       for(int i=0;i<row.length;i+=2){
46            int c1=row[i]/2;
47            int c2=row[i+1]/2;
48
49            dsu.Union(c1,c2);
50       }
51
52       int ans=0;
53
54       for(int i=0;i<n;i++){
55            if(dsu.find(i)==i){
56                ans+=dsu.size[i]-1;
57            }
58       }
59
60       return ans;
61    }
62}
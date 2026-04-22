// Last updated: 22/04/2026, 18:53:42
1class Solution {
2   
3    class DSU{
4        int[] parent;
5        
6        DSU(int n){
7            parent=new int[n];
8            for(int i =0;i<n;i++) parent[i]=i;
9        }
10
11        int find(int node){
12            if(parent[node]==node) return node;
13            return parent[node] = find(parent[node]);
14        }
15
16        void union(int u,int v){
17            int ulp=find(u);
18            int vlp=find(v);
19
20            if (ulp != vlp) {
21                parent[vlp]=ulp;
22            }
23
24            
25        }
26    }
27    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
28        
29        int n=source.length;
30
31        DSU dsu=new DSU(n);
32
33        for (int[] swap : allowedSwaps) {
34            dsu.union(swap[0], swap[1]);
35        }
36
37        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
38
39        for (int i = 0; i < n; i++) {
40            int parent = dsu.find(i);
41
42            groups.putIfAbsent(parent, new HashMap<>());
43            Map<Integer, Integer> freq = groups.get(parent);
44
45            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
46        }
47        int result = 0;
48
49        for (int i = 0; i < n; i++) {
50            int parent = dsu.find(i);
51            Map<Integer, Integer> freq = groups.get(parent);
52
53            if (freq.getOrDefault(target[i], 0) > 0) {
54                freq.put(target[i], freq.get(target[i]) - 1);
55            } else {
56                result++; // mismatch
57            }
58        }
59
60        return result;
61    }
62}
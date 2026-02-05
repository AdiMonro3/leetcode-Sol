// Last updated: 05/02/2026, 11:56:53
1class Solution {
2    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
3        if(edges.length==0){
4            List<Integer> t=new ArrayList<>();
5            t.add(0);
6            return t;
7        }
8        int [] degree=new int[n];
9        List<List<Integer>> adj=new ArrayList<>();
10        for(int i=0;i<n;i++){
11            adj.add(new ArrayList<>());
12        }
13        for(int i=0;i<edges.length;i++){
14            int u=edges[i][0];
15            int v=edges[i][1];
16
17            adj.get(u).add(v);
18            adj.get(v).add(u);
19
20            degree[u]++;
21            degree[v]++;
22        }
23        int cnt=n;
24        Queue<Integer> leaves=new ArrayDeque<>();
25        for(int i=0;i<n;i++){
26            if(degree[i]==1) leaves.offer(i);
27        }
28        while (cnt > 2) {
29            int size = leaves.size();
30            cnt -= size;
31            for (int i = 0; i < size; i++) {
32                int v = leaves.poll();
33                for (int w : adj.get(v)) {
34                    degree[w]--;
35                    if (degree[w] == 1) {
36                        leaves.add(w);
37                    }
38                }
39            }
40        }
41
42        List<Integer> ans=new ArrayList<>();
43        while(!leaves.isEmpty()){
44            ans.add(leaves.poll());
45        }
46        return ans;
47    }
48}
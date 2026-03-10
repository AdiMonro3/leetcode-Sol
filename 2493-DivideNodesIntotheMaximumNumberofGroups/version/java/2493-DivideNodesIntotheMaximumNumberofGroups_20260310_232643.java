// Last updated: 10/03/2026, 23:26:43
1import java.util.*;
2
3class Solution {
4
5    public int magnificentSets(int n, int[][] edges) {
6
7        List<List<Integer>> adj = new ArrayList<>();
8
9        for(int i=0;i<=n;i++)
10            adj.add(new ArrayList<>());
11
12        for(int[] e : edges){
13            adj.get(e[0]).add(e[1]);
14            adj.get(e[1]).add(e[0]);
15        }
16
17        // Step 1: check bipartite
18        int[] color = new int[n+1];
19        Arrays.fill(color,-1);
20
21        for(int i=1;i<=n;i++){
22            if(color[i]==-1){
23                Queue<Integer> q = new ArrayDeque<>();
24                q.offer(i);
25                color[i]=0;
26
27                while(!q.isEmpty()){
28                    int node=q.poll();
29
30                    for(int nei:adj.get(node)){
31                        if(color[nei]==-1){
32                            color[nei]=1-color[node];
33                            q.offer(nei);
34                        }
35                        else if(color[nei]==color[node]){
36                            return -1;
37                        }
38                    }
39                }
40            }
41        }
42
43        int ans=0;
44
45        // Step 2: compute BFS depth
46        int[] depth = new int[n+1];
47
48        for(int i=1;i<=n;i++){
49
50            Queue<Integer> q = new ArrayDeque<>();
51            boolean[] vis = new boolean[n+1];
52
53            q.offer(i);
54            vis[i]=true;
55
56            int level=0;
57
58            while(!q.isEmpty()){
59
60                int size=q.size();
61                level++;
62
63                for(int j=0;j<size;j++){
64
65                    int node=q.poll();
66
67                    for(int nei:adj.get(node)){
68                        if(!vis[nei]){
69                            vis[nei]=true;
70                            q.offer(nei);
71                        }
72                    }
73                }
74            }
75
76            depth[i]=level;
77        }
78
79        // Step 3: sum maximum depth per component
80        boolean[] visited = new boolean[n+1];
81
82        for(int i=1;i<=n;i++){
83
84            if(!visited[i]){
85
86                Queue<Integer> q = new ArrayDeque<>();
87                q.offer(i);
88                visited[i]=true;
89
90                int maxDepth=0;
91
92                while(!q.isEmpty()){
93
94                    int node=q.poll();
95                    maxDepth=Math.max(maxDepth,depth[node]);
96
97                    for(int nei:adj.get(node)){
98                        if(!visited[nei]){
99                            visited[nei]=true;
100                            q.offer(nei);
101                        }
102                    }
103                }
104
105                ans+=maxDepth;
106            }
107        }
108
109        return ans;
110    }
111}
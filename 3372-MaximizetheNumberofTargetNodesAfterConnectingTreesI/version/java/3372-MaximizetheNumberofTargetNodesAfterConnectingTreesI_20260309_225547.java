// Last updated: 09/03/2026, 22:55:47
1class Solution {
2    int n;
3        int m;
4        public  void helper(List<List<Integer>> adj,int[]nodes,int k,int start){
5            int len=nodes.length;
6            Queue<Integer> q=new ArrayDeque<>();
7            q.offer(start);
8            int level=0;
9            boolean[] visited=new boolean[len+1];
10            visited[start]=true;
11            while(!q.isEmpty()){
12                int size=q.size();
13                while(size>0){
14                    int temp=q.poll();
15                    if(level<=k){
16                        nodes[start]++;
17                        for(int v:adj.get(temp)){
18                            if(!visited[v]){
19                                visited[v]=true;
20                                q.offer(v);
21                            }
22                        }
23                    }
24                    size--;
25                }
26                level++;
27            }
28        }
29        public  int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
30            n=edges1.length;
31            m=edges2.length;
32            List<List<Integer>> adj1=new ArrayList<>();
33            for(int i=0;i<n+1;i++){
34                adj1.add(new ArrayList<>());
35            }
36            for(int i=0;i<n;i++){
37                int u=edges1[i][0];
38                int v=edges1[i][1];
39
40                adj1.get(u).add(v);
41                adj1.get(v).add(u);
42            }
43            List<List<Integer>> adj2=new ArrayList<>();
44            for(int i=0;i<m+1;i++){
45                adj2.add(new ArrayList<>());
46            }
47            for(int i=0;i<m;i++){
48                int u=edges2[i][0];
49                int v=edges2[i][1];
50
51                adj2.get(u).add(v);
52                adj2.get(v).add(u);
53            }
54
55            int []temp1=new int[n+1];
56            int []temp2=new int[m+1];
57
58            for(int i=0;i<n+1;i++){
59                helper(adj1,temp1,k,i);
60
61            }
62            for(int i=0;i<m+1;i++){
63                helper(adj2,temp2,k-1,i);
64            }
65
66            int max=Integer.MIN_VALUE;
67            for(int i=0;i<m+1;i++){
68                max=Math.max(max,temp2[i]);
69            }
70
71
72
73            for(int i=0;i<n+1;i++){
74                temp1[i]+=max;
75            }
76            return temp1;
77        }
78}
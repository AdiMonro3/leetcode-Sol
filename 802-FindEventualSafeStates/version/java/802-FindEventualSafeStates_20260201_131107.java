// Last updated: 01/02/2026, 13:11:07
1class Solution {
2    boolean visited[];
3    boolean pathvisited[];
4    int n;
5    public boolean dfs(int [][] graph,int u){
6        visited[u]=true;
7        pathvisited[u]=true;
8        for(int v:graph[u]){
9            if(!visited[v]){
10                if(dfs(graph,v)) return true;
11            }else if(pathvisited[v]){
12                return true;
13            }
14        }
15        pathvisited[u]=false;
16        return false;
17    }
18    public List<Integer> eventualSafeNodes(int[][] graph) {
19        n=graph.length;
20        visited=new boolean[n];
21        pathvisited=new boolean[n];
22
23        for(int i=0;i<n;i++){
24            if(!visited[i]){
25                dfs(graph,i);
26            }
27        }
28        List<Integer> ans=new ArrayList<>();
29        for(int i=0;i<n;i++){
30            if(!pathvisited[i]){
31                ans.add(i);
32            }
33        }
34        return ans;
35
36    }
37}
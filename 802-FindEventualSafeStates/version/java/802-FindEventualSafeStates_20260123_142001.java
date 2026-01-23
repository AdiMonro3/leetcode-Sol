// Last updated: 23/01/2026, 14:20:01
1class Solution {
2    public boolean cycleDetection(int[][] adj,int u,boolean[] pathVisited,boolean visited[]){
3         visited[u]=true;
4            pathVisited[u]=true;
5
6            for(int v:adj[u]){
7                //if not visited
8                if(visited[v]==false){
9                    // check for cycle 
10                    boolean b=cycleDetection(adj, v, pathVisited, visited);
11                    if(b==true) return true;
12                }
13                else if(pathVisited[v]==true) return true;
14
15            }
16            // remove from path before returning
17            pathVisited[u]=false;
18
19            return false;
20    }
21    public List<Integer> eventualSafeNodes(int[][] graph) {
22         int n=graph.length;
23       boolean[] visited=new boolean[n];
24       boolean[] pathVisited=new boolean[n];
25        for(int i=0;i<graph.length;i++){
26            if(visited[i]==false){
27                cycleDetection(graph,i,pathVisited,visited);
28            }
29        }
30        List<Integer> result=new ArrayList<>();
31        for(int i = 0; i<n; i++) {
32            if(!pathVisited[i])
33                result.add(i);
34        }
35        
36        return result;
37    }
38}
// Last updated: 05/07/2026, 01:01:53
1class Solution {
2    public boolean dfsTopo(List<List<Integer>> adj,Deque<Integer> st,boolean[] visited,boolean[]inPath,int u){
3        inPath[u]=true;
4        visited[u]=true;
5        for(int v:adj.get(u)){
6            if(inPath[v]){
7                return false;
8            }
9            if(!visited[v]){
10                dfsTopo(adj,st,visited,inPath,v);
11            }
12        }
13        inPath[u]=false;
14        st.push(u);
15        return true;
16    }
17    public boolean canFinish(int n, int[][] p) {
18        List<List<Integer>> adj=new ArrayList<>();
19
20        for(int i=0;i<n;i++){
21            adj.add(new ArrayList<>());
22        }
23
24        for(int[] temp:p){
25            int u=temp[0];
26            int v=temp[1];
27
28            adj.get(u).add(v);
29        }
30        Deque<Integer> st = new ArrayDeque<>();
31        boolean[] visited=new boolean[n];
32        boolean[] inPath=new boolean[n];
33
34        for(int i=0;i<n;i++){
35            if(!visited[i]){
36                if(!dfsTopo(adj,st,visited,inPath,i)) return false;
37            }
38        }
39
40        if(st.size()==n) return true;
41
42        return false;
43    }
44}
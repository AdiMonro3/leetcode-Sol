// Last updated: 29/01/2026, 19:32:42
1class Solution {
2    public void helper(int n,int []indegree,List<List<Integer>> graph,HashMap<Integer,HashSet<Integer>> map){
3        Queue<Integer> q=new ArrayDeque<>();
4        for(int i=0;i<n;i++){
5            if(indegree[i]==0) q.offer(i);
6        }
7        while(!q.isEmpty()){
8            int u=q.poll();
9            for(Integer v: graph.get(u)){
10                indegree[v]--;
11                map.putIfAbsent(v, new HashSet<>());
12                map.get(v).add(u);
13                // and v also depends on all prerequisites of u
14                if (map.containsKey(u)) {
15                    map.get(v).addAll(map.get(u));
16                }
17                if(indegree[v]==0) q.offer(v);
18            }
19        }
20
21    }
22    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] edges, int[][] queries) {
23        int n=numCourses;
24        int indegree[]=new int[n];
25        List<List<Integer>> graph=new ArrayList<>();
26        for(int i=0;i<n;i++){
27            graph.add(new ArrayList<>());
28        }
29        for(int i=0;i<edges.length;i++){
30            int u=edges[i][0];
31            int v=edges[i][1];
32            indegree[v]++;
33            graph.get(u).add(v);
34        }
35        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
36        helper(n, indegree, graph, map);
37
38    List<Boolean> ans = new ArrayList<>();
39    for (int[] q : queries) {
40        int u = q[0], v = q[1];
41        ans.add(map.containsKey(v) && map.get(v).contains(u));
42    }
43
44    return ans;
45
46    }
47}
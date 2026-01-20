// Last updated: 20/01/2026, 12:20:27
1class Solution {
2    public boolean helper(List<List<Integer>> adj,int[]indegree,int numCourses){
3        Queue<Integer> q=new ArrayDeque<>();
4        int topoSort=0;
5        for(int i=0;i<indegree.length;i++){
6            if(indegree[i]==0){
7                q.add(i);
8            }
9        }
10        while(!q.isEmpty()){
11            int p=q.poll();
12            topoSort++;
13
14            for(Integer i:adj.get(p)){
15                indegree[i]--;
16                if(indegree[i]==0) q.add(i);
17            }
18        }
19        if(topoSort<numCourses){
20            return false;
21        }
22        return true;
23    }
24
25    public boolean canFinish(int numCourses, int[][] prerequisites) {
26        List<List<Integer>> adjlist=new ArrayList<>();
27        int[] indegree=new int[numCourses];
28        for(int i=0;i<numCourses;i++){
29            adjlist.add(new ArrayList<>());
30        }
31        for(int i=0;i<prerequisites.length;i++){
32            int u=prerequisites[i][0];
33            int v=prerequisites[i][1];
34            indegree[u]++;
35            adjlist.get(v).add(u);
36        }
37
38        return helper(adjlist,indegree,numCourses);
39    }
40}
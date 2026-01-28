// Last updated: 28/01/2026, 21:37:35
1class Solution {
2    public int shortestPathLength(int[][] graph) {
3        int n = graph.length;
4        
5		if(n == 1 || n == 0)
6			return 0;
7        
8        int allVisitedState = (1 << n) - 1;
9        Queue<int []> que = new LinkedList<>();
10        
11		int [][] visited = new int [n][allVisitedState+1];
12
13		for(int i=0; i<graph.length; i++) {
14			que.add(new int [] {i, 1 << i});
15            visited[i][(1 << i)] = 1;  
16		}
17
18
19
20		int shortestPath = 0;
21		while(!que.isEmpty()){
22			int size = que.size();
23			shortestPath++;
24			for(int i=0; i<size; i++){
25                
26				int [] curr  = que.poll();
27				int currNode = curr[0];
28				int currMask = curr[1];
29                
30				for(int adj : graph[currNode]){
31					int nextMask = currMask | (1 << adj);
32
33					if(visited[adj][nextMask] == 1)
34                        continue;
35                    
36                    if(nextMask == allVisitedState)
37						return shortestPath;
38                    
39                    visited[adj][nextMask] = 1;
40					que.add(new int [] {adj, nextMask});
41				}
42			}
43		}
44		return -1;
45	}
46}
// Last updated: 14/02/2026, 17:27:37
1class Solution {
2    public int[][] DIRS = {{0, 0}, {0, 1}, {1, 0}, {-1, 0}, {0, -1}};
3    public int getInitialState(int[][] mat,int n,int m){
4        int initialstate=0;
5        for(int i=0;i<n;i++){
6            for(int j=0;j<m;j++){
7                initialstate|=(mat[i][j]<<(i*m+j));
8            }
9        }
10        return initialstate;
11    }
12    public List<Integer> getNextStates(int currState,int n,int m){
13        List<Integer> nextStates=new ArrayList<>();
14        for(int i=0;i<n;i++){
15            for(int j=0;j<m;j++){
16                int nextstate=currState;
17                for (int[] dir : DIRS) {
18                    int nextRow = i + dir[0];
19                    int nextCol = j + dir[1];
20                    if (isInBoundary(nextRow, nextCol, n, m)) { 
21                        nextstate ^=1<<(nextRow*m+nextCol);
22                    }
23                }
24                nextStates.add(nextstate);
25            }
26        }
27        return nextStates;
28
29    }
30    public boolean isInBoundary(int row, int col, int m, int n) {
31        return row >= 0 && row < m && col >= 0 && col < n;
32    }
33    public int bfs(int [][] mat ,int n,int m){
34
35        int initialState=getInitialState(mat,n,m);
36        HashSet<Integer> visited=new HashSet<>();
37        Queue<Integer> q=new ArrayDeque<>();
38        
39
40        int steps=0;
41        q.offer(initialState);
42        visited.add(initialState);
43        while(!q.isEmpty()){
44            int size = q.size();
45
46            for (int k = 0; k < size; k++) {
47                int currState=q.poll();
48                if(currState==0) return steps;
49            
50
51                List<Integer> nextStates=getNextStates(currState,n,m);
52                for(int nextState : nextStates){
53                    if(!visited.contains(nextState)){
54                        q.offer(nextState);
55                        visited.add(nextState);
56                    }
57                }
58
59            }
60            steps++;
61        }
62        return -1;
63    }
64    public int minFlips(int[][] mat) {
65        int n=mat.length;
66        int m=mat[0].length;
67        return bfs(mat,n,m);
68    }
69}
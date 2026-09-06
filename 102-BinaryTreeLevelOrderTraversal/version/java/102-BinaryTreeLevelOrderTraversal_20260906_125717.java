// Last updated: 06/09/2026, 12:57:17
1class Solution {
2    public int[][] highestPeak(int[][] isWater) {
3        int m=isWater.length;
4        int n=isWater[0].length;
5
6        // Initialize result matrix with same dimensions as input
7        int[][] matrix=new int[m][n];
8
9        // Queue to perform BFS
10        Queue<int[]> que=new LinkedList<>();
11
12
13        // Initialize matrix and queue
14        for(int i=0; i<m; i++){
15            for(int j=0; j<n; j++){
16                if(isWater[i][j]==1){
17                    // Water cells have height 0 and are added to queue
18                    que.add(new int[]{i,j});
19                }
20                else{
21                    // Mark land cells as unvisited (-1)
22                    matrix[i][j]=-1;
23                }
24            }
25        }
26
27
28        // Possible directions: right, left, down, up
29        int[][] directions={ {0,1}, {0,-1}, {1,0}, {-1,0} };
30
31        //BFS Traverse
32        while(!que.isEmpty()){
33            int[] arr=que.poll();
34            int r=arr[0];
35            int c=arr[1];
36
37            // Check all adjacent cells
38            for(int[] dir:directions){
39                int nr=r+dir[0];
40                int nc=c+dir[1];
41
42                // If adjacent cell is within boundary and unvisited
43                if(nr>=0 && nr<m && nc>=0 && nc<n && matrix[nr][nc]==-1){
44                    // Set height to 1 more than current cell
45                    matrix[nr][nc]=matrix[r][c]+1;  
46
47                    // Add to queue for further exploration
48                    que.add(new int[]{nr,nc});      
49                } 
50            }
51        }
52
53        return matrix;
54    }
55}
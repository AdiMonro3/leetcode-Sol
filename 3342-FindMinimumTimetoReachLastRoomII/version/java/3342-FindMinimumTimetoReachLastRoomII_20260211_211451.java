// Last updated: 11/02/2026, 21:14:51
1// class Solution {
2//     class Pair{
3//         int row;
4//         int col;
5//         int time;
6//         int cost;
7//         Pair(int i,int j,int t,int c){
8//             row=i;
9//             col=j;
10//             time=t;
11//             cost=c;
12//         }
13//     }
14//     int n;
15//     int m;
16//     int dist[][];
17//     int INF = (int)1e9;
18//     int[]dr={-1,0,1,0};
19//     int[]dc={0,1,0,-1};
20//     public int helper(int[][] move,int i,int j){
21//         PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.time-b.time);
22//         q.offer(new Pair(0,0,0,1));
23
24//         while(!q.isEmpty()){
25//             Pair temp=q.poll();
26//             int row=temp.row;
27//             int col=temp.col;
28//             int time=temp.time;
29//             int cost=temp.cost;//when we take next step what is our cost
30           
31
32
33//             if(row==n-1 && col==m-1) return time; 
34//             if(time > dist[row][col]) continue;
35
36//             for(int d=0;d<4;d++){
37//                 int nrow=row+dr[d];
38//                 int ncol=col+dc[d];
39
40//                 if(nrow<0 || ncol<0 || nrow>=n || ncol>=m) continue;
41
42//                 int wait = Math.max(move[nrow][ncol] - time, 0);
43//                 int arrivalTime = time + wait + cost;
44
45//                     if (dist[nrow][ncol] > arrivalTime) {
46//                         dist[nrow][ncol] = arrivalTime;
47//                         q.offer(new Pair(nrow,ncol,arrivalTime,cost==1 ? 2 : 1));
48//                     }
49                
50                
51//             }
52//         }
53//     return -1;
54//     }
55//     public int minTimeToReach(int[][] moveTime) {
56//         n=moveTime.length;
57//         m=moveTime[0].length;
58//         dist=new int[n][m];
59//         for (int i = 0; i < n; i++){
60//             Arrays.fill(dist[i], INF);
61//         }
62//         dist[0][0]=0;
63//         return helper(moveTime,0,0);
64//     }
65// }
66class Solution{
67  private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
68
69    static class Cell implements Comparable<Cell> {
70        int time, row, col;
71
72        Cell(int time, int row, int col) {
73            this.time = time;
74            this.row = row;
75            this.col = col;
76        }
77
78        @Override
79        public int compareTo(Cell other) {
80            return Integer.compare(this.time, other.time);
81        }
82    }
83
84    public int minTimeToReach(int[][] moveTime) {
85        int m = moveTime.length;
86        int n = moveTime[0].length;
87
88        int[][] result = new int[m][n];
89        for (int[] row : result) {
90            Arrays.fill(row, Integer.MAX_VALUE);
91        }
92
93        PriorityQueue<Cell> pq = new PriorityQueue<>();
94        result[0][0] = 0;
95        pq.offer(new Cell(0, 0, 0));
96
97        while (!pq.isEmpty()) {
98            Cell curr = pq.poll();
99
100            if (curr.row == m - 1 && curr.col == n - 1) {
101                return curr.time;
102            }
103
104            for (int[] dir : directions) {
105                int newRow = curr.row + dir[0];
106                int newCol = curr.col + dir[1];
107
108                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
109                    int moveCost = (newRow + newCol) % 2 == 0 ? 2 : 1;
110                    int wait = Math.max(moveTime[newRow][newCol] - curr.time, 0);
111                    int arrivalTime = curr.time + wait + moveCost;
112
113                    if (result[newRow][newCol] > arrivalTime) {
114                        result[newRow][newCol] = arrivalTime;
115                        pq.offer(new Cell(arrivalTime, newRow, newCol));
116                    }
117                }
118            }
119        }
120
121        return -1;
122    }
123}
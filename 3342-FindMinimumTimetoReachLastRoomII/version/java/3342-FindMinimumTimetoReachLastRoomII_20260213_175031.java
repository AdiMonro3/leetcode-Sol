// Last updated: 13/02/2026, 17:50:31
1class Solution {
2    class Pair{
3        int row;
4        int col;
5        int time;
6       
7        Pair(int i,int j,int t){
8            row=i;
9            col=j;
10            time=t;
11          
12        }
13    }
14    int n;
15    int m;
16    int dist[][];
17    int INF = (int)1e9;
18    int[]dr={-1,0,1,0};
19    int[]dc={0,1,0,-1};
20    public int helper(int[][] move,int i,int j){
21        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->a.time-b.time);
22        q.offer(new Pair(0,0,0));
23
24        while(!q.isEmpty()){
25            Pair temp=q.poll();
26            int row=temp.row;
27            int col=temp.col;
28            int time=temp.time;
29      
30           
31
32
33            if(row==n-1 && col==m-1) return time; 
34            if(time > dist[row][col]) continue;
35
36            for(int d=0;d<4;d++){
37                int nrow=row+dr[d];
38                int ncol=col+dc[d];
39
40                if(nrow<0 || ncol<0 || nrow>=n || ncol>=m) continue;
41                int cost = (nrow + ncol) % 2 == 0 ? 2 : 1;
42                int wait = Math.max(move[nrow][ncol] - time, 0);
43                int arrivalTime = time + wait + cost;
44
45                    if (dist[nrow][ncol] > arrivalTime) {
46                        dist[nrow][ncol] = arrivalTime;
47                        q.offer(new Pair(nrow,ncol,arrivalTime));
48                    }
49                
50                
51            }
52        }
53    return -1;
54    }
55    public int minTimeToReach(int[][] moveTime) {
56        n=moveTime.length;
57        m=moveTime[0].length;
58        dist=new int[n][m];
59        for (int i = 0; i < n; i++){
60            Arrays.fill(dist[i], Integer.MAX_VALUE);
61        }
62        dist[0][0]=0;
63        return helper(moveTime,0,0);
64    }
65}
66
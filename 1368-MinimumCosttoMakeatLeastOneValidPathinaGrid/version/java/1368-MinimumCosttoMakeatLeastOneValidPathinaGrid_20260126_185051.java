// Last updated: 26/01/2026, 18:50:51
1class Solution {
2    class Pair{
3        int val;
4        int row;
5        int col;
6        public Pair(int val,int row,int col){
7            this.val=val;
8            this.row=row;
9            this.col=col;
10        }
11    }
12    int [][]result;
13    int n;
14    int m;
15    int dr[]={0,0,1,-1};
16    int dc[]={1,-1,0,0};
17    public int djkistra(int [][] grid,int x,int y){
18        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.val-b.val);
19        pq.offer(new Pair(0,x,y));
20        result[x][y] = 0;
21        while(!pq.isEmpty()){
22            Pair p=pq.poll();
23            int currCost=p.val;
24            int row=p.row;
25            int col=p.col;
26            for(int i=0;i<4;i++){
27                int newRow=row+dr[i];
28                int newCol=col+dc[i];
29                if(newRow>=0 && newRow<n && newCol>=0 && newCol<m){
30                    int gridDir = grid[row][col];
31                    int dirCost = ((gridDir - 1 != i) ? 1 : 0);
32
33                    int newCost = currCost + dirCost;
34
35                    if (newCost < result[newRow][newCol]) {
36                        result[newRow][newCol] = newCost;
37                        pq.offer(new Pair(newCost,newRow,newCol));
38                    }
39                }
40            }
41        }
42        return result[n- 1][m - 1];
43
44    }
45    public int minCost(int[][] grid) {
46        n=grid.length;
47        m=grid[0].length;
48        result=new int[n][m];
49        for(int i=0;i<n;i++){
50            Arrays.fill(result[i],Integer.MAX_VALUE);
51        }
52        return djkistra(grid,0,0);
53    }
54}
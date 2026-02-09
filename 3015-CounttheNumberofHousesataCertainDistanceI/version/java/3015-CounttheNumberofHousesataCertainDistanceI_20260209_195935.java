// Last updated: 09/02/2026, 19:59:35
1class Solution {
2    int INF=Integer.MAX_VALUE;
3    public void floydWarshall(int[][] dist,int n){
4        for(int k=1;k<=n;k++){// intermediate
5            for(int i=1;i<=n;i++){//source
6                for(int j=1;j<=n;j++){// destination
7                    if (dist[i][k] != INF && dist[k][j] != INF){
8                        dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
9                    }
10                }
11            }
12        }
13    }
14    public int[] countOfPairs(int n, int x, int y) {
15        int[][] dist=new int[n+1][n+1];
16
17        for(int i=0;i<=n;i++){
18            for(int j=0;j<=n;j++){
19                if(i==j) dist[i][j]=0;
20                else dist[i][j]=INF;
21            }
22        }
23
24        for(int i=1;i<=n-1;i++){
25            int u=i;
26            int v=i+1;
27            dist[u][v]=1;
28            dist[v][u]=1;
29        }
30
31        if(x!=y){
32            dist[x][y]=1;
33            dist[y][x]=1;
34        }
35        floydWarshall(dist,n);
36        int ans[]=new int[n];
37        for(int i=1;i<=n;i++){
38            for(int j=1;j<=n;j++){
39                int a=dist[i][j];
40                if(a!=0 && a!=INF){
41                    ans[a-1]++;
42                }
43            }
44        }
45        return ans;
46    }
47}
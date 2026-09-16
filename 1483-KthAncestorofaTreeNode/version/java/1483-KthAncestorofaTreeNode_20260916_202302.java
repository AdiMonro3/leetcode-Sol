// Last updated: 16/09/2026, 20:23:02
1class TreeAncestor {
2        int[][] up;
3        int log;
4    public TreeAncestor(int n, int[] parent) {
5        log = (int) (Math.log(n) / Math.log(2)) + 1;
6            up = new int[n+1][log];
7
8            for(int i=0;i<=n;i++){
9                for(int j=0;j<log;j++){
10                    up[i][j]=-1;
11                }
12            }
13
14            for(int i=0;i<n;i++){
15                up[i][0]=parent[i];
16            }
17
18            for(int i=1;i<log;i++){
19                for(int j=1;j<=n;j++){
20                    int prev=up[j][i-1];
21                    if (prev != -1) {
22                        up[j][i] = up[prev][i-1];
23                    }
24                }
25            }
26    }
27    
28    public int getKthAncestor(int node, int k) {
29         for (int j = 0; j < log; j++) {
30                if ((k & (1 << j)) != 0) {
31                    node = up[node][j];
32                    // Instantly exit the function if out of bounds
33                    if (node == -1) {
34                        return -1; 
35                    }
36                }
37            }
38            return node;
39    }
40}
41
42
43/**
44 * Your TreeAncestor object will be instantiated and called as such:
45 * TreeAncestor obj = new TreeAncestor(n, parent);
46 * int param_1 = obj.getKthAncestor(node,k);
47 */
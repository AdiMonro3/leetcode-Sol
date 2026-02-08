// Last updated: 08/02/2026, 22:41:32
1class Solution {
2         StringBuilder ans = new StringBuilder();
3    Set<String> used = new HashSet<>();
4    int k;
5
6    public String crackSafe(int n, int k) {
7        this.k = k;
8
9        // start node = n-1 zeros
10        String start = "";
11        for (int i = 0; i < n - 1; i++) start += "0";
12
13        dfs(start);
14
15        // prepend start
16        ans.append(start);
17        return ans.toString();
18    }
19
20    private void dfs(String node) {
21        for (int d = 0; d < k; d++) {
22
23            String edge = node + d;
24
25            if (!used.contains(edge)) {
26                used.add(edge);
27
28                String next = edge.substring(1);
29                dfs(next);
30
31                ans.append(d);   // post-order (key step)
32            }
33        }
34    }
35    
36}
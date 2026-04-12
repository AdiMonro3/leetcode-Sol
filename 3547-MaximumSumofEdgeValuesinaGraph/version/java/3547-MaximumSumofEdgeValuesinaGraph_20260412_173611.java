// Last updated: 12/04/2026, 17:36:11
1class Solution {
2    public long maxScore(int n, int[][] edges) {
3
4        if(n==1) return 1;
5        if(n==2) return 2;
6
7        int m=edges.length;
8        long  sum=0;
9
10        int degree[]=new int[n];
11        for(int i=0;i<m;i++){
12            int u=edges[i][0];
13            int v=edges[i][1];
14
15         
16
17            degree[u]+=1;
18            degree[v]+=1;
19        }
20        
21        int cycle=1;
22
23        for(int i=0;i<n;i++){
24
25            if(degree[i]==1) {
26                cycle=0;
27                break;
28            }
29        }
30        System.out.println(cycle);
31        long odd=0;
32        int oddprev=0;
33        for(int i=1;i<=n;i=i+2){
34
35            odd += (long)oddprev * i;
36            oddprev=i;
37
38        }
39       
40        long even=0;
41        int evenprev=0;
42        for(int i=2;i<=n;i=i+2){
43
44           even += (long)evenprev * i;
45            evenprev=i;
46
47        }
48       
49        long temp = (long)n * (n - 1);
50        sum=odd+even+temp;
51        if(cycle==1){
52            return sum+=(long)2;
53        }
54
55        return sum;
56    }
57}
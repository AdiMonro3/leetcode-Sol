// Last updated: 05/04/2026, 10:48:35
1class Solution {
2    class Pair{
3        int val;
4        int i;
5        int j;
6
7        Pair(int val,int i,int j){
8            this.val=val;
9            this.i=i;
10            this.j=j;
11        }
12    }
13    int n;
14    int m;
15    public int maxIncreasingCells(int[][] mat) {
16        
17        n=mat.length;
18        m=mat[0].length;
19
20        List<Pair> list=new ArrayList<>();
21        for(int i=0;i<n;i++){
22            for(int j=0;j<m;j++){
23                int val=mat[i][j];
24                list.add(new Pair(val,i,j));
25            }
26        }
27
28        Collections.sort(list,(a,b)-> a.val-b.val);
29
30        int [] maxRow = new int[n];
31        int [] maxCol = new int[m];
32
33        int[][] dp = new int[n][m];
34
35        int max = 0;
36
37        int i=0;
38
39       while(i<list.size()){
40
41            Pair p=list.get(i);
42            int val=p.val;
43            // int row=p.i;
44            // int col=p.j;
45            int j=i;
46            List<int[]> temp = new ArrayList<>();
47
48            while (j < list.size() && val == list.get(j).val) {
49
50                int currRow = list.get(j).i;
51                int currCol = list.get(j).j;
52
53                int currDp = Math.max(maxRow[currRow], maxCol[currCol]) + 1;
54
55                temp.add(new int[]{currRow, currCol, currDp});
56
57                max = Math.max(max, currDp);
58
59                j++;
60            }
61
62            // now update AFTER processing all same values
63            for (int[] t : temp) {
64                int r = t[0], c = t[1], valDp = t[2];
65
66                dp[r][c] = valDp;
67                maxRow[r] = Math.max(maxRow[r], valDp);
68                maxCol[c] = Math.max(maxCol[c], valDp);
69            }
70
71            i = j;
72        }
73
74       
75
76        return max;
77    }
78}
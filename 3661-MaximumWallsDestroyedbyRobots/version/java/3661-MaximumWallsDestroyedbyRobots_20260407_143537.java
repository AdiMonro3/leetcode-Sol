// Last updated: 07/04/2026, 14:35:37
1class Solution {
2    int lStart[];
3    int lEnd[];
4    int rStart[];
5    int rEnd[];
6
7    int leftGain[];
8    int rightGain[];
9    int common[];
10    int[][] memo;
11    int n;
12    int m;
13    public int lowerBound(int[] walls,int target){
14        int i=0;
15        int j=walls.length;
16
17        while(i<j){
18            int mid=(i+j)/2;
19            if(walls[mid]<target){
20                i=mid+1;
21            }else{
22                j=mid;
23            }
24        }
25        return i;
26    }
27    public int helper(int i,int dir){
28        if(i>=n) return 0;
29
30        if(dir!=-1 && memo[i][dir] != -1) return memo[i][dir];
31
32        int left=0;
33        int right=0;
34        if(dir==-1){
35            left=leftGain[i]+helper(i+1,0);
36            right=rightGain[i]+helper(i+1,1);
37        }else{
38            if(dir==0){
39                left=leftGain[i]+helper(i+1,0);
40            }else{
41                left=(leftGain[i] - common[i])+helper(i+1,0);
42            }
43            right=rightGain[i]+helper(i+1,1);
44        }
45
46        
47        if(dir!=-1){
48            memo[i][dir]=Math.max(left,right);
49        }
50
51        return Math.max(left,right);
52    }
53    public int maxWalls(int[] robots, int[] distance, int[] walls) {
54
55
56        n=robots.length;
57        m=walls.length;
58
59        Arrays.sort(walls);
60        int[][] temp = new int[n][2];
61        for(int i = 0; i < n; i++){
62            temp[i][0] = robots[i];
63            temp[i][1] = distance[i];
64        }
65
66        Arrays.sort(temp, (a,b) -> a[0] - b[0]);
67
68        for(int i = 0; i < n; i++){
69            robots[i] = temp[i][0];
70            distance[i] = temp[i][1];
71        }
72        lStart=new int[n];
73        lEnd=new int[n];
74        rStart=new int[n];
75        rEnd=new int[n];
76        leftGain = new int[n];
77        rightGain = new int[n];
78        common = new int[n];
79
80        for(int i=0;i<n;i++){
81
82            int l=robots[i]-distance[i];
83            int r=robots[i]+distance[i];
84
85            if(i != 0){
86                l = Math.max(l, robots[i-1] + 1);
87            }
88            if(i != n-1){
89                r = Math.min(r, robots[i+1] - 1);
90            }
91
92            lStart[i]=lowerBound(walls,l);
93            lEnd[i]=lowerBound(walls,robots[i]+1);
94
95            rStart[i]=lowerBound(walls,robots[i]);
96            rEnd[i]=lowerBound(walls,r+1);
97
98            leftGain[i]=Math.max(0,lEnd[i] - lStart[i]);
99            rightGain[i]=Math.max(0, rEnd[i] - rStart[i]);
100
101            if(i!=0){
102                int start = Math.max(rStart[i-1], lStart[i]);
103                int end = Math.min(rEnd[i-1], lEnd[i]);
104
105                System.out.println(start+" "+ end);
106                common[i] = Math.max(0, end - start);
107            }
108
109        }
110        memo = new int[n][2];
111        for(int[] row : memo) Arrays.fill(row, -1);
112
113        return helper(0,-1);
114        
115    }
116}
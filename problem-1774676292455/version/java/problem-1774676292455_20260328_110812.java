// Last updated: 28/03/2026, 11:08:12
1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int n=grid.length;
4        int m=grid[0].length;
5
6        long[] horizontalSum=new long[n];
7        long[] verticalSum=new long[m];
8
9        for(int i=0;i<n;i++){
10            long sum=0;
11            for(int j=0;j<m;j++){
12                sum+=grid[i][j];
13            }
14
15            if(i==0){
16                horizontalSum[i]=sum;
17                continue;
18            }
19
20            horizontalSum[i]=horizontalSum[i-1]+sum;
21        }
22        
23        for(int i=0;i<m;i++){
24            long sum=0;
25            for(int j=0;j<n;j++){
26                sum+=grid[j][i];
27            }
28
29            if(i==0){
30                verticalSum[i]=sum;
31                continue;
32            }
33
34            verticalSum[i]=verticalSum[i-1]+sum;
35        }
36        System.out.println(Arrays.toString(horizontalSum));
37        System.out.println(Arrays.toString(verticalSum));
38
39        long leftSum=0;
40        long rightSum=0;
41
42        for(int i=1;i<n;i++){
43            leftSum=horizontalSum[i-1];
44            rightSum=horizontalSum[n-1]-horizontalSum[i-1];
45
46
47            if(leftSum==rightSum) return true;
48        }
49
50        for(int i=1;i<m;i++){
51            leftSum=verticalSum[i-1];
52            rightSum=verticalSum[m-1]-verticalSum[i-1];
53
54          
55            if(leftSum==rightSum) return true;
56        }
57     
58        return false;
59    }
60}
// Last updated: 28/04/2026, 23:51:29
1class Solution {
2    public int minOperations(int[][] grid, int x) {
3        int n=grid.length;
4        int m=grid[0].length;
5        int nums[]=new int[n*m];
6
7        int k=0;
8
9        for(int i=0;i<n;i++){
10            for(int j=0;j<m;j++){
11                nums[k]=grid[i][j];
12                k++;
13            }
14        }
15
16        Arrays.sort(nums);
17        int median=0;
18        if(nums.length%2==0){
19            median = nums[nums.length / 2];
20        }
21        else{
22            median=nums[nums.length/2];
23        }
24
25        int ans=0;
26
27        for(int i=0;i<nums.length;i++){
28            int diff=Math.abs(nums[i]-median);
29            if(diff%x==0){
30                ans+=diff/x;
31            }else{
32                return -1;
33            }
34        }
35
36
37        return ans;
38    }
39}